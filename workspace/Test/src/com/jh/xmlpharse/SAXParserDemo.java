package com.jh.xmlpharse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo extends DefaultHandler{

	private String content = null;
	
	public String getContent(){
		return content;
	}
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("****¡¡start doc ¡Á¡Á¡Á¡Á¡Á" );
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		System.out.println("localName = " + localName + "\t qName = " +  qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		content = String.valueOf(ch, start, length);
		System.out.println(content);
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}
	

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("****¡¡end doc ¡Á¡Á¡Á¡Á¡Á" );
	}


	public SAXParserDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		
		SAXParserFactory saxf = SAXParserFactory.newInstance();
		saxf.setNamespaceAware(true);
		SAXParser saxp = saxf.newSAXParser();
		
		SAXParserDemo saxDemo = new SAXParserDemo();
		
		
		try {
			saxp.parse(new File("Country.xml"), saxDemo );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("*************************************");
		System.out.println(saxDemo.getContent());
		
//		System.out.println("\n******************** 2 xxxxxxxxxxxxxxxxxx");
////		saxp.setProperty(name, value);
//		
//		
//		
//		XMLReader xmlReader = saxp.getXMLReader();
//		xmlReader.setContentHandler(new SAXParserDemo());
//		try {
//			xmlReader.parse(new InputSource(new FileReader("Country.xml")));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
