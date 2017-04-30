package com.mariner.jconvert;

/**
 The combine_csv class implements logic to combine 3 files into one.
 
 This is to be used in the jconvert project, see README.md

 Agile Task:
 Title:
 "Create a java class capable of combining 3 files into one" 
	
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
 
class combine_csv {
 
	public static void combine_csv() throws Exception {
		String mergedFilePath = ".";
 
		File[] files = new File[3];
		files[0] = new File(commons.OUTPUT_JSON2CVS);
		files[1] = new File(commons.OUTPUT_XML2CSV);
		files[2] = new File(commons.INPUT_CSV);
 
		File mergedFile = new File(mergedFilePath);
 
		mergeFiles(files, mergedFile);
	}
 
	public static void mergeFiles(File[] files, File mergedFile) throws Exception {
 
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			// TODO create a better catch so the user does see a more friendly message
			e1.printStackTrace();
			throw new Exception(e1); // bubble up the exception
		}
 
		for (File f : files) {
			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
 
				in.close();
			} catch (IOException e) {
				// TODO create a better catch so the user does see a more friendly message
				e.printStackTrace();
				throw new Exception(e); // bubble up the exception
			}
		}
 
		try {
			out.close();
		} catch (IOException e) {
			// TODO create a better catch so the user does see a more friendly message
			e.printStackTrace();
			throw new Exception(e); // bubble up the exception
		}
 
	}
}
