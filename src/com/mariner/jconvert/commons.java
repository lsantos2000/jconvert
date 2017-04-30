package com.mariner.jconvert;

/**
 The commons class implements common static constants.
 
 This is to be used in the jconvert project, see README.md

 Agile Task:
 Title:
 "Create a common constant class so it can be used by other classes in the same projects" 
	
*/

public class commons {

	static final String CSV_HEADER = "max-hole-size,packets-serviced,packets-requested,client-guid,client-address,request-time,service-guid,retries-request";

	static final String INPUT_CSV = "reports.csv";
	static final String INPUT_XML = "reports.xml";
	static final String INPUT_XSL = "reports.xsl";
	static final String INPUT_JSON = "reports.json";	
	
	static final String OUTPUT_JSON2CVS = "json2csv_out.csv";
	static final String OUTPUT_XML2CSV = "xml2csv_out.csv";
	static final String OUTPUT_COMBINEDCVS = "combined.csv";
	static final String OUTPUT_RESULTING_CVS = "result.csv";
	
	static final int PACKETS_SERVICES_POSITION = 6; // packets-serviced is at pos 6 (positions start at zero) 
	
} 
 
 
