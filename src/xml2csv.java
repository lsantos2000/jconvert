/**
 The convert_xml2csv class implements logic to convert an xml file to csv
 
 This is to be used in the jconvert project, see README.md

 Agile Task:
 Title:
 "Create a java class capable of taking an xml file with xsl tneplate format defined, and converting to a csv file.  
	
*/

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

class xml2csv {

	public static void convert_xml2csv() throws Exception {
		File stylesheet = new File(commons.INPUT_XSL); // we had to create a schema for this
		File xmlSource = new File(commons.INPUT_XML);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(xmlSource);

		StreamSource stylesource = new StreamSource(stylesheet);
		Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
		Source source = new DOMSource(document);
		Result outputTarget = new StreamResult(new File(commons.OUTPUT_XML2CSV));
		transformer.transform(source, outputTarget);
	}
}