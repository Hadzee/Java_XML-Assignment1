
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {

        XPathFactory xPathFactory = XPathFactory.newInstance();

        XPath xPath = xPathFactory.newXPath();

        XPathExpression xPathExpression = xPath.compile("//book[price > 10 and translate(publish_date, '-', '') > 20050101]/*");

        File file = new File("books.xml");

        InputSource inputSource = new InputSource(new FileInputStream(file));

        Object object = xPathExpression.evaluate(inputSource, XPathConstants.NODESET);

        NodeList nodeList = (NodeList) object;

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("node name : " + nodeList.item(i).getNodeName());
            System.out.println("\tnode value : " + nodeList.item(i).getFirstChild().getNodeValue());
        }

    }
}
