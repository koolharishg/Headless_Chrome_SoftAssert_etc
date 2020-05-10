package com.bazinga.pom.testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyProg {

	public static void main(String[] args) throws IOException {
		String target_dir = "C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Files";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		for (File f : files) {

			if (f.isFile()) {
				BufferedReader inputStream = null;

				try {
					inputStream = new BufferedReader(new FileReader(f));
					String line;

					while ((line = inputStream.readLine()) != null) {
						String[] baz = line.split(",");
						if (baz.length == 2) {
							System.out.println(baz[1]);
						} else {
							break;
						}

					}

				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
				}
			}
		}

	}

}