package com.mariner.jconvert;
/**
 The jconvert class implements a java main application that implements the following requirements:

 Agile Story:
 
 Story Points: 13
 
 Story Title:
 
 "As a Mariner, I want to create a Java application that reads, filters and sorts 3 different file formats and 
  outputs a csv file."
  
 Story Description:

	Read the 3 input files reports.json, reports.csv, reports.xml and output a combined CSV file with the following characteristics:
	
	- The same column order and formatting as reports.csv
	- All report records with packets-serviced equal to zero should be excluded
	- records should be sorted by request-time in ascending order
	
	Additionally, the application should print a summary showing the number of records in the output file associated with each service-guid.
	
	Please provide source, documentation on how to run the program and an explanation on why you chose the tools/libraries used. 
	
*/

class jconvert {

	public static void main(String[] args) {
		/// The approach here will be to convert non-csv files to csv, combine the 3 csv files, then remove non-zero and sort
		System.out.println("jconvert started");
		try {
			System.out.println("jconvert is converting xml2cs into " + commons.OUTPUT_XML2CSV);
			xml2csv.convert_xml2csv();
			
			System.out.println("jconvert is converting json2cvs into " + commons.OUTPUT_JSON2CVS);
			json2cvs.convert_json2cvs();
			
			System.out.println("jconvert is combining cvs files into " + commons.OUTPUT_COMBINEDCVS);
			combine_csv.combine_csv(); 
			
			System.out.println("jconvert is applying sort and filter rules into " + commons.OUTPUT_RESULTING_CVS);
			int lines = sort_csv.sort_csv_files();
			
			System.out.println("jconvert has successfully completed its tasks ");
			System.out.println("************************");
			System.out.println("Total of lines: " + lines);
			
		} catch (Exception e) {
			// TODO create a better catch so the user does see a more friendly message
			e.printStackTrace();
		}
	}

}
