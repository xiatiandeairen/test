package jarTest.dom4j;

import java.io.File;
import java.util.List;
import java.util.ListIterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * JDOM方式解析xml文件
 * @author xiatao
 *
 */
public class JDOMTest {

	public static void main(String arge[]) { 
		long lasting = System.currentTimeMillis(); 
		try { 
			SAXBuilder builder = new SAXBuilder(); 
			Document doc = builder.build(new File("index.xml")); 
			Element root = doc.getRootElement(); 
			getChild(root);
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}
	
	/**
	 * 递归遍历
	 * @param root
	 */
	public static void getChild(Element root) {
		List<Element> allChildren = root.getChildren(); 
		ListIterator iterator = allChildren.listIterator();
		while(iterator.hasNext()) {
			Element next = (Element) iterator.next();
			System.out.println(next.getName());
			getChild(next);
		}
	}
}