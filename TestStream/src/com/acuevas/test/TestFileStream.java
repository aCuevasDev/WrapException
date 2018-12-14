package com.acuevas.test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestFileStream {

	private static List<String> strings = Arrays.asList("aa", "bb");

	private static void readAll() {
		try {
			strings.stream().map(File::new).forEach(TestFileStream::safeRead);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	private static void safeRead(File file) throws RuntimeException {
		// wraps the exception into a RuntimeException to be unchecked and get through
		// the forEach
		try {
			read(file);
		} catch (IOException e) {
			// I have to instantiate a RuntimeException to set the StackTrace properly.
			RuntimeException runtimeException = new RuntimeException(e);
			runtimeException.setStackTrace(e.getStackTrace());
			throw runtimeException;
		}
	}

	private static void read(File file) throws IOException {
		// just doing random things to test the exception
		if (file.getName().equals("aa"))
			System.out.println(file.getName());
		if (file.getName().equals("bb"))
			throw new IOException("ERROR");
	}

	public static void main(String[] args) {
		readAll();
	}
}
