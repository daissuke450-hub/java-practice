package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import bean.User;

public class MultiInsert {

	private static final int THREAD_COUNT = 4;

	public List<User> multithread(String filePath) throws IOException, InterruptedException {

		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		List<User> list = new CopyOnWriteArrayList<>();

		ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
		CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			reader.readLine(); // ヘッダー

			while ((line = reader.readLine()) != null) {
				queue.put(line);
			}
		}

		for (int i = 0; i < THREAD_COUNT; i++) {
			queue.put("POISON_PILL");
		}

		for (int i = 0; i < THREAD_COUNT; i++) {
			executor.execute(() -> {
				try {
					while (true) {
						String line = queue.take();
						if ("POISON_PILL".equals(line))
							break;

						String[] parts = line.split(",");
						if (parts.length >= 3) {
							User user = new User();
							user.setId(Integer.parseInt(parts[0]));
							user.setName(parts[1]);
							user.setEmail(parts[2]);
							list.add(user);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					latch.countDown();
				}
			});
		}

		latch.await();
		executor.shutdown();

		return list;

	}

}
