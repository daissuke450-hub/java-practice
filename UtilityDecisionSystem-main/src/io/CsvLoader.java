package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Option;

public class CsvLoader {

	private static final Logger logger = LogManager.getLogger(CsvLoader.class);

	public List<Option> load(String filePath) throws IOException {

		List<Option> options = new ArrayList<Option>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			logger.info("CSVファイルの読み込み開始", filePath);

			while ((line = reader.readLine()) != null) {
				String[] p = line.split(",");
				Option option = new Option(p[0],
						Double.parseDouble(p[1]),
						Double.parseDouble(p[2]),
						Double.parseDouble(p[3]),
						Double.parseDouble(p[4])

				);
				options.add(option);

			}
		}

		return options;

	}

}
