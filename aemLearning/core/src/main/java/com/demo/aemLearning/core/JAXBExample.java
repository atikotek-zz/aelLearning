package com.demo.aemLearning.core;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

//import com.demo.aemLearning.core.Employee;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;


public class JAXBExample {

    private static final String FILE_NAME = "jaxb-emp.xml";

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setAge(25);
        emp.setName("Avinash");
        emp.setGender("Male");
        emp.setRole("Developer");
        emp.setPassword("sensitive");

        jaxbObjectToXML(emp);

        //Employee empFromFile = jaxbObjectToXML();
      // System.out.println(.toString());
    }


//    private static Employee jaxbXMLToObject() {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Employee.class);
//            Unmarshaller un = context.createUnmarshaller();
//            Employee emp = (Employee) un.unmarshal(new File(FILE_NAME));
//            return emp;
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    private static void jaxbObjectToXML(Employee emp) {

        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            // m.marshal(emp, System.out);

            // Write to File
          m.marshal(emp, new File(FILE_NAME));
         
       // create document object from the student.xml
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder docBuilder = null;
		try {
			docBuilder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          Document document = null;
		try {
			document = docBuilder.parse(FILE_NAME);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          // print the marshalled object to the stdout
          TransformerFactory tf = TransformerFactory.newInstance();
          Transformer t = null;
		try {
			t = tf.newTransformer();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          try {
			t.transform(new DOMSource(document), new StreamResult(System.out));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
