# Data sorting and filtering

Read the 3 input files reports.json, reports.csv, reports.xml and output a combined CSV file with the following characteristics:

- The same column order and formatting as reports.csv
- All report records with packets-serviced equal to zero should be excluded
- records should be sorted by request-time in ascending order

Additionally, the application should print a summary showing the number of records in the output file associated with each service-guid.

Please provide source, documentation on how to run the program and an explanation on why you chose the tools/libraries used.

## Submission

You may fork this repo, commit your work and let us know of your project's location, or you may email us your project files in a zip file.

## Implementation

Main class is jconvert.java

Jar dependencies:

Download Apache Commons IP from here http://commons.apache.org/proper/commons-io/download_io.cgi
Download org.json https://stleary.github.io/JSON-java/
(alternative would be json simple from http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm but code will have to be modified)
