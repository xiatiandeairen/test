package com.dom4j.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * dom4j使用
 * @author xiatao
 *
 */
public class XMLParse {
	public static void main(String[] args) throws Exception {
		xmlParse2();
		xmlParse();
	}
	/**
	 * 解析xml文件
	 * @throws Exception
	 */
	public static void xmlParse() throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("index.xml"));
		Element root = doc.getRootElement();
		Iterator iterator = root.elementIterator();
		while(iterator.hasNext()) {
			Element book = (Element) iterator.next();
			Iterator attrs = book.attributeIterator();
			System.out.println(book.getName());
			while(attrs.hasNext()) {
				Attribute attr = (Attribute) attrs.next();
				System.out.println(attr.getName()+":"+attr.getValue()+":"+attr.getText());
			}
			Iterator es = book.elementIterator();
			while(es.hasNext()) {
				Element next = (Element) es.next();
				System.out.println(next.getName()+":"+next.getText());
			}
		}
	}
	
	/**
	 * 写入xml文件
	 * @throws Exception
	 */
	public static void xmlParse2() throws Exception {
		Document document = DocumentHelper.createDocument();
		//		document.addElement("books").addElement("book").addAttribute("id", "b01");
		Element root = document.addElement("books");
		Element book = root.addElement("book");
		book.addAttribute("id", "b01");
		Element name = book.addElement("name");
		Element author = book.addElement("author");
		Element price = book.addElement("price");
		name.addText("Thinking in Java");
		author.addText("xiaowei");
		price.addText("88");
		Element book1 = root.addElement("book");
		book1.addAttribute("id", "b02");
		Element name1 = book1.addElement("name");
		Element author1 = book1.addElement("author");
		Element price1 = book1.addElement("price");
		name1.addText("hahahah");
		author1.addText("xiaohu");
		price1.addText("162");
		//		FileWriter writer = new FileWriter(new File("index.xml"));
		//		document.write(writer);
		//		writer.close();
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter writer=new XMLWriter(new FileWriter(new File("index.xml")),format);
		writer.write(document);
		writer.close();
		
	}
}
