package escribir_xml;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;
import escribir_xml.Animal;
import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Escribir_Leer_XML {
    private static ArrayList <Animal> animales_escribir;
    public static void rellenar_array(){
        animales_escribir = new ArrayList<>();
   
        animales_escribir.add(new Animal(0,"Coco", 5, "Granada", "Hernandez"));
        animales_escribir.add(new Animal(1,"Misy", 2, "Jaen", "Rodriguez"));
        animales_escribir.add(new Animal(2,"Simba", 3, "Ciudad del Cabo", "Sanchez"));
        animales_escribir.add(new Animal(3,"Cuqui", 5, "Málaga", "Carrasco"));
        animales_escribir.add(new Animal(4,"Tiger", 10, "Nairobi", "Cabello"));
    }
    
    public static void main(String args[]) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException{
        //ESCRIBIR
        rellenar_array();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Animales", null);
        document.setXmlVersion("1.0"); 
        for(int i = 0; i<animales_escribir.size();i++){
            Element raiz = document.createElement("Animal"); //nodo empleado
            document.getDocumentElement().appendChild(raiz); 

            CrearElemento("id", Integer.toString(animales_escribir.get(i).getId()), raiz, document); 
            CrearElemento("nombre", animales_escribir.get(i).getNombre(), raiz, document); 
            CrearElemento("anios", Integer.toString(animales_escribir.get(i).getAnios()), raiz, document);
            CrearElemento("provincia", animales_escribir.get(i).getProvincia(), raiz, document); 
            CrearElemento("apellido_familia", animales_escribir.get(i).getFamilia(), raiz, document); 
        }	 
        
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("Animales.xml"));        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        
        
        //Leer
        
        XMLReader  procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor= new GestionContenido();  
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("Animales.xml");	    
        procesadorXML.parse(fileXML);
    }
 

    
    
    static void  CrearElemento(String datoEmple, String valor, Element raiz, Document document){
        Element elem = document.createElement(datoEmple); 
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }
   
}

class GestionContenido extends DefaultHandler {	 
    ArrayList <Animal> animal_leer = new ArrayList();
    Animal animal;
    String name= "";
    public GestionContenido() {
        super();
        name ="";
        animal = new Animal();
    }	    
    public void startDocument() {
        System.out.println("Comienzo del Documento XML");
    }	    
    public void endDocument() {
        System.out.println("Final del Documento XML");
        System.out.println("\nARRAY");
        this.print_array();
    }	 	    
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("\t Principio Elemento: %s %n",nombre);
        name = nombre;
    } 	
    public void endElement(String uri, String nombre, String nombreC) {
        System.out.printf("\tFin Elemento: %s %n", nombre);
        if(nombre == "Animal"){
            print_animal();
            animal_leer.add(animal);
            animal = new Animal();
        }
       
    }	
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        String car=new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]","");	   
        System.out.printf ("\t Caracteres: %s %n", car);

        if (name == "id"){
            animal.setId(Integer.parseInt(car));
        }else if (name == "nombre"){
            animal.setNombre(car);
        }else if (name == "anios"){
            animal.setAnios(Integer.parseInt(car));
        } else if (name == "provincia"){
            animal.setProvincia(car);
        } else if (name == "apellido_familia"){
            animal.setFamilia(car);
        }
    }	
    
    public void print_animal(){
        System.out.println("Animal: "+ animal.getId()+ " "+animal.getNombre()+ " "+ animal.getAnios()+ " "+animal.getProvincia()+" " +animal.getFamilia() + "\n");
    }
    public void print_array(){
        for(Animal anim : animal_leer){
           System.out.println("Animal: "+ anim.getId()+ " "+anim.getNombre()+ " "+ anim.getAnios()+ " "+anim.getProvincia()+" " +anim.getFamilia() + "\n");
        }
    }
}
