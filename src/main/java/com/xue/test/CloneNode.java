package com.xue.test;

import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by baxue on 7/1/2015.
 */
public class CloneNode {


	public static void main(String[] args) throws Exception{

		String xmlString = decode();

		Document doc = parse(xmlString);

		Document node = (Document)doc.cloneNode(true);

		print(node);

	}

	private static void print(Document node) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
		DOMImplementationLS impl = (DOMImplementationLS)registry.getDOMImplementation("LS");
		LSSerializer writer = impl.createLSSerializer();
		writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
		writer.getDomConfig().setParameter("xml-declaration", true);
		String s = writer.writeToString(node);
		System.out.println(s);
	}

	private static Document parse(String xmlString) throws ParserConfigurationException, SAXException, IOException{
		InputSource input = new InputSource(xmlString);
		input.setCharacterStream(new java.io.StringReader(xmlString));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(input);
	}

	private static String decode() throws FileNotFoundException{
		XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("z:\\browserpropsANDcookierules\\HRPRD\\browserprops.xml")));
		String xmlString = (String)d.readObject();
		d.close();
		return xmlString;
	}
}
