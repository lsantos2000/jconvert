/**
 The convert_xml2csv class implements logic to convert an xml file to csv
 
 This is to be used in the jconvert project, see README.md

 Agile Task:
 Title:
 "Create a java class capable of sorting  a csv file by different criterias.  
	
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Comparator;


public class sort_csv {
	
	/* Implement a Comparable to fulfill this requirement:
	 * - records should be sorted by request-time in ascending order
	 * 
	 */
	@SuppressWarnings("unchecked")
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<String, List<String>> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll((Collection<? extends Entry<K, V>>) map.entrySet());
	    return sortedEntries;
	}
	
	
	/* Implement the actual sort_csv_files method to fulfill these requirements:
	 * - All report records with packets-serviced equal to zero should be excluded
	 * - records should be sorted by request-time in ascending order
	 */
    @SuppressWarnings("unchecked")
	public static int sort_csv_files() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(commons.OUTPUT_COMBINEDCVS));
        Map<String, List<String>> map = new TreeMap<String, List<String>>();
        String line = "";
        String header = reader.readLine(); // read header, assume is first line
        while ((line = reader.readLine()) != null) {
        	// get a key so we remove duplicates
            String key = getField(line);
            List<String> l = map.get(key);
            if (l == null) {
                l = new LinkedList<String>();
                map.put(key, l);
            }
            l.add(line);

        }
        // sort the map using a Comparable to implement the sorting by date column (which is an integer)
        map = (Map<String, List<String>>) entriesSortedByValues(map);

        reader.close();
        FileWriter writer = new FileWriter(commons.OUTPUT_RESULTING_CVS);
        writer.write(header + "\n");
        // count number of lines
        int lines = 0;
        for (List<String> list : map.values()) {
            for (String val : list) {
				// only add lines where packet-services at PACKETS_SERVICES_POSITION <> 0
            	if (Integer.parseInt(getPacketsServicesField(val)) != 0)  {
                    writer.write(val);
                    lines++;
                    writer.write("\n");
            	}

            }
        }
        writer.close();
		return lines;
    }

    private static String getField(String line) {
        return line.split(",")[0];// extract value you want to sort on
    }
    
    private static String getPacketsServicesField(String line) {
        return line.split(",")[commons.PACKETS_SERVICES_POSITION];// extract value you want to sort on
    }    

}

