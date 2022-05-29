package TESEBADA;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Text;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


 
public class ArchivoXML{
	
private static Document document;
  
public  void CrearArchivo(String EmployeeID,String FirstName, String LastName, String Title, String Division, String Build,String Room) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{ 
      String ruta= "C:\\Users\\e-jslopez\\OneDrive - NEORIS\\Desktop\\CRUDXMK\\Datos\\Documento.xml";
    File file= new File(ruta);
    String TagPrincipal="RegistroEmpleados";
    DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
    DocumentBuilder db= dbf.newDocumentBuilder();
    Document doc = db.parse(file);
    doc.getDocumentElement().normalize();
    NodeList nlist= doc.getElementsByTagName("Employee");
    doc= db.parse(file);
    Element eRaiz= doc.getDocumentElement();
    Element eEmployee= doc.createElement("Employee");
    
    Element empid= doc.createElement("EmployeeID");
    empid.appendChild(doc.createTextNode(EmployeeID));
    eEmployee.appendChild(empid);
    
    Element firstName= doc.createElement("FirstName");
    firstName.appendChild(doc.createTextNode(FirstName));
    eEmployee.appendChild(firstName);
    
    Element lastName= doc.createElement("LastName");
    lastName.appendChild(doc.createTextNode(LastName));
    eEmployee.appendChild(lastName);
    
    Element title= doc.createElement("Title");
    title.appendChild(doc.createTextNode(Title));
    eEmployee.appendChild(title);

    Element division= doc.createElement("Division");
    division.appendChild(doc.createTextNode(Division));
    eEmployee.appendChild(division);
    
    Element build= doc.createElement("Building");
    build.appendChild(doc.createTextNode(Build));
    eEmployee.appendChild(build);
    
    Element room= doc.createElement("Room");
    room.appendChild(doc.createTextNode(Room));
    eEmployee.appendChild(room);
    
    eRaiz.appendChild(eEmployee);
    
    TransformerFactory tf =TransformerFactory.newInstance();
    Transformer t= tf.newTransformer();
    DOMSource dom =new DOMSource(doc);
    StreamResult result = new StreamResult(file);
    t.transform(dom, result);     
 
}
public void leerArchivo(String archivo,String tag) {
  try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File(archivo));
            NodeList lista = documento.getElementsByTagName(tag);
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo;
                    NodeList hijos = e.getChildNodes();
                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("Propiedad: \n" + hijo.getNodeName()
                                    + ", Valor: \n" + hijo.getTextContent());
                        }
 
                    }
                    System.out.println("");
                }
 
            }
 
        } catch (ParserConfigurationException |SAXException|  IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
public void Eliminar(String id) {
    try {
            Document d = (Document) DomHelper.getDocument("src\\\\\\\\Datos\\\\\\\\Documento.xml");
            NodeList nl = d.getElementsByTagName("Employee");
            for (int i = 0; i < nl.getLength(); i++) {
                Element student = (Element) nl.item(i);
                if (student.getElementsByTagName("EmployeeID").item(0).getTextContent().equals(id)) {
                    student.getParentNode().removeChild(student);
                }
            }
            
            DomHelper.saveXMLContent(d, "src\\\\Datos\\\\Documento.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    JOptionPane.showMessageDialog(null, "Se ELIMINO DEL  Archivo");
}
public  void buscarEmp(String id)
{
	try {
		  Document d = (Document) DomHelper.getDocument("C:\\Users\\e-jslopez\\OneDrive - NEORIS\\Desktop\\CRUDXMK\\Datos\\Documento.xml");
          NodeList nl = d.getElementsByTagName("Employee");
          for (int i = 0; i < nl.getLength(); i++) {
              Element emp = (Element) nl.item(i);
              if (emp.getElementsByTagName("EmployeeID").item(0).getTextContent().equals(id)) {
                  emp.getParentNode().getChildNodes();
                 System.out.println("Propiedad: "+emp.getNodeName()+"\n\n"+"Valor:"+ emp.getTextContent());
              }
          }

          DomHelper.saveXMLContent(d, "src\\Datos\\Documentos.xml");
      } catch (Exception e) {
          System.out.println(e.getMessage());
      
	}

}

} 


