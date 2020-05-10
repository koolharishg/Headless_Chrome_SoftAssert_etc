package com.bazinga.pom.testcases.Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class ReadAllFiles {

	@Test
	public void readFile() throws IOException {

		String target_dir = "C:\\Users\\ghorh\\Documents\\seleniumbazinga\\Files";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		for (int i = 0; i < 4; i++) {
			BufferedReader bf = new BufferedReader(new FileReader(files[i]));
			String line;
			try {
				while ((line = bf.readLine()) != null) {
					System.out.println(bf.readLine());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (bf != null) {
					try {
						bf.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

}
