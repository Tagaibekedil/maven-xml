package kg.megalab;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document=builder.parse(new File("employees.xml"));
        List<Employee>employees=new ArrayList<>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element elem=(Element) node;
                  String ID=node.getAttributes().getNamedItem("ID").getNodeValue();
                String firstname=elem.getElementsByTagName("Firstname")
                        .item(0).getChildNodes().item(0).getNodeValue();
                String lastname=elem.getElementsByTagName("Lastname")
                        .item(0).getChildNodes().item(0).getNodeValue();
                int age=Integer.parseInt(elem.getElementsByTagName("Age")
                        .item(0).getChildNodes().item(0).getNodeValue());
                double salary=Double.parseDouble(elem.getElementsByTagName("Salary")
                        .item(0).getChildNodes().item(0).getNodeValue());
                String name=elem.getElementsByTagName("Name")
                               .item(0).getChildNodes().item(0).getNodeValue();
                int exp=Integer.parseInt(elem.getElementsByTagName("Exp")
                        .item(0).getChildNodes().item(0).getNodeValue());
                 employees.add(new Employee(ID,firstname,lastname,age,salary,new Position(name,exp)));
            }
        }for (Employee empl:employees)
            System.out.println(empl.toString());
    }
}
