package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Option;

public class ResultWriter {
	public void write(Option option, String outputPath) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
			writer.println("一番いい案は：" + option.getName());
		}
	}

}
