package xml;


import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;

public class DomXmlMain {

    public static void main(String[]args)throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbf.newDocumentBuilder();
        Document doc = dbuilder.parse(new FileInputStream("book.xml"));
        pringDoc(doc, 0);
    }

    public static void pringDoc(Node n, int indent){
        for(int i = 0 ; i < indent; i++){
            System.out.print(' ');
        }

        switch(n.getNodeType()){
            case Node.DOCUMENT_NODE:
                System.out.println("Document : " + n.getNodeName());
                break;
            case Node.ELEMENT_NODE:
                System.out.println("Element : " + n.getNodeName());
                break;
            case Node.TEXT_NODE:
                System.out.println("Text : " + n.getNodeValue());
                break;
            case Node.COMMENT_NODE:
                System.out.println("Comment : " + n.getNodeValue());
                break;
        }

        for(Node child = n.getFirstChild();child != null; child = child.getNextSibling()){
            pringDoc(child, indent + 1);
        }
    }
}
