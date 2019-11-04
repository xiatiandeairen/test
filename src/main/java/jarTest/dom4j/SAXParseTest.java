package jarTest.dom4j;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX解析xml文件
 * @author xiatao
 *
 */
public class SAXParseTest {

	public static void main(String args[]) { 
		long lasting = System.currentTimeMillis(); 
		try { 
			SAXParserFactory sf = SAXParserFactory.newInstance(); 
			SAXParser sp = sf.newSAXParser(); 
			Handler reader = new Handler(); 
			sp.parse(new InputSource("index.xml"), reader); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}
}
class Handler extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		System.out.println("文档开始");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("文档结束");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("uri:"+uri+" localName:"+localName+ " qName:"+qName+" attributes:"+attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("uri:"+uri+" localName:"+localName+" qName:"+qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(new String(ch, start, length));
	}
	
}