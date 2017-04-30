package com.mariner.jconvert;
/**
 The convert_json2cvs class implements logic to convert a json file to csv
 
 This is to be used in the jconvert project, see README.md

 Agile Task:
 Title:
 "Create a java class capable of taking a json file and converting to a csv file.  
 
 
 Note: this project can also be used instead: https://github.com/Arkni/json-to-csv
 
	
*/

import java.io.File;
import java.io.IOException;

// apache commons http://commons.apache.org/downloads/
import org.apache.commons.io.FileUtils; // general file manipulation utilities.

// or.json https://stleary.github.io/JSON-java/
import org.json.CDL; //  provides static methods to convert comma delimited text into a JSONArray
import org.json.JSONArray; // more json manipulation
import org.json.JSONException;
import org.json.JSONObject;

public class json2cvs {

	@SuppressWarnings("deprecation")
	public static void convert_json2cvs() throws Exception {
		// just a "template" json so the doc is properly created
		String jsonString = "[ { 'max-hole-size': 10, 'packets-serviced': 17, 'packets-requested': 13, 'client-guid': '14946fd5-489e-4865-8e6a-e0cb15b7d197', 'client-address': '200.47.19.120', 'request-time': 1467175919322, 'service-guid': 'caaca31e-bee2-4ed3-8e72-5dab24079744', 'retries-request': 6 }";

		JSONObject output;
		try {
			output = new JSONObject(jsonString);

			JSONArray docs = output.getJSONArray("[]");

			File file = new File(commons.OUTPUT_JSON2CVS);
			String csv = CDL.toString(docs);
			FileUtils.writeStringToFile(file, csv);
		} catch (JSONException e) {
			// TODO create a better catch so the user does see a more friendly message
			e.printStackTrace();
			throw new Exception(e); // bubble up the exception
		} catch (IOException e) {
			// TODO create a better catch so the user does see a more friendly message
			e.printStackTrace();
			throw new Exception(e); // bubble up the exception
		}
	}

}