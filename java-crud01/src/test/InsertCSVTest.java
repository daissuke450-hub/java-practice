package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bean.User;
import csv.InsertCSV;

class InsertCSVTest {

	private Path tempFile;

	@BeforeEach
	void setUp() throws IOException {
		// testFile
		tempFile = Files.createTempFile("test-users", "csv");

	}

	@AfterEach
	void tearDown() throws IOException {
		Files.deleteIfExists(tempFile);
	}

	@Test
	void testCsvList_nomal() throws IOException {
		// 正常データ
		try (FileWriter writer = new FileWriter(tempFile.toFile())) {
			writer.write("山田太郎,yamada@example.com\n");
			writer.write("佐藤花子,hanako@example.com\n");
		}

		InsertCSV parser = new InsertCSV();
		List<User> users = parser.csvList(tempFile.toString());

		assertEquals(2, users.size());
		assertEquals("山田太郎", users.get(0).getName());
		assertEquals("hanako@example.com", users.get(1).getEmail());

	}

	@Test
	void restCsvList_invalidFormat() throws IOException {
		try (FileWriter writer = new FileWriter(tempFile.toFile())) {
			writer.write("不正な行\n");
		}

		InsertCSV parser = new InsertCSV();
		List<User> users = parser.csvList(tempFile.toString());

		assertEquals(0, users.size());

	}

	@Test
	void testCsvList_emptyFile() throws IOException {

		InsertCSV parser = new InsertCSV();
		List<User> users = parser.csvList(tempFile.toString());

		assertTrue(users.isEmpty());

	}

	@Test
	void testCsvList_fileNotFound() {
		InsertCSV parser = new InsertCSV();
		List<User> users = parser.csvList("non_existent_file.csv");

		assertTrue(users.isEmpty());
	}

}
