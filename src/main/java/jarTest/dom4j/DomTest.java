package jarTest.dom4j;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Dom方式读取xml文件
 * @author xiatao
 *
 */
public class DomTest {
	public static void main(String arge[]){ 
		XMLParse("index.xml");
	}
	
	/**
	 * XML解析遍历
	 */
	public static void XMLParse(String filePath) {
		try{ 
			File f=new File(filePath); 
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder=factory.newDocumentBuilder(); 
			Document doc = builder.parse(f); 
			Node root = doc.getFirstChild();
			String name =root.getNodeName();
			System.out.println(name);
			getChildNode(root);
		}catch(Exception e){ 
			e.printStackTrace(); 
		}
	}
	
	/**
	 * 递归遍历子节点，输出子节点的信息
	 * @param node 起始节点
	 */
	public static void getChildNode(Node node) {
		NodeList nodeList = node.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++) {
			Node n=nodeList.item(i);
//			System.out.println(n.getNodeName());
			System.out.println(n.getNodeName()+":"+n.getNodeValue());
			getChildNode(n);
		}
	}
}
