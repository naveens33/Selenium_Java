package junit_datadriven_excel;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Repository {
/*
  public static void main(String argv[]) {
  
	  System.out.println(getlocator("index","signin"));
	  System.out.println(getlocator("index","onlinebanking"));
	  System.out.println(getlocator("login","username"));
	  System.out.println(getlocator("login","password"));
  }
  */
  public static String getlocator(String page,String element)
  {
    try {

	File fXmlFile = new File("src\\junit_datadriven_excel\\ZeroBank.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	NodeList nList = doc.getElementsByTagName(page);
			

		Node nNode = nList.item(0);
								
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			return(eElement.getElementsByTagName(element).item(0).getTextContent());
		}
	
    } catch (Exception e) {
    	e.printStackTrace();
    	return "Error";
    }
	return "Error";
  }

}