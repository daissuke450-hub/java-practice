package sample02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

	public List<StockRecord> load(String filePath) throws IOException {

		List<StockRecord> list = new ArrayList<StockRecord>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			String line = reader.readLine();

			while ((line = reader.readLine()) != null) {

				String[] parts = line.split(",");

				StockRecord record = new StockRecord(
						LocalDate.parse(parts[0], formatter),
						Double.parseDouble(parts[1]),
						Double.parseDouble(parts[2]),
						Double.parseDouble(parts[3]),
						Double.parseDouble(parts[4]),
						Long.parseLong(parts[5])

				);

				list.add(record);

			}

		}

		return list;

	}

}
