package toolbox;
import java.io.File;
//import java.io.FileOutputStream;
//import java.text.DecimalFormat;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
 
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
//import org.jdom.output.Format;
//import org.jdom.output.XMLOutputter;
 
/**
 * class for XML file manipulation
 * @author imen
 */
public class XmlFileRW {
	
     org.jdom.Document document;
     Element root;
	 
     public Element getRoot() {
		return root;
	}


	public void setRoot(Element root) {
		this.root = root;
	}


	String path="" ;
     
	//DecimalFormat df = new DecimalFormat ( ) ;
	 //Element route;
	 //Lock l = new ReentrantLock();
	
	 /**
     * read the XMl file
     * @param path of the XML file
     */
	 public XmlFileRW(String path){
		 this.path=path;
		 
	 }
	 
	 
	 /**
	 * read the XMl file
	 * @param file path of the XML file
	 */ 
	 public void readRoot()
	 {
		 // On crée une instance de SAXBuilder
        SAXBuilder sxb = new SAXBuilder();
        try 
        {
        	// On crée un nouveau document JDOM avec le fichier XML en argument
            document = sxb.build(new File(path));
        } 
        catch (Exception e) {
        	System.out.println(e.getMessage());
        }

        // On initialise un nouvel élément racine avec l'élément racine du document
        root = document.getRootElement(); 
 	}
	 
 

	 
	 /**
	  * save the XMl file
	  * @param file name of the new XML file
	  */ 
//	 private synchronized  void save(String file)
//	 {
//		 try
//		 {
//			 XMLOutputter sortie=new XMLOutputter(Format.getPrettyFormat());
//			 sortie.output(document, new FileOutputStream(file));
//		 }
//		 catch(java.io.IOException e){};
//	 } 
	 
	 //Getter & setter
     
	 public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


/**
 * add a value to the tag "cons"
 * @param ad value to add
 */ 
	 
	 /*
public synchronized  void addCons(Double ad){
	
	l.lock();
	Double nb;
	try { 	 route=this.read(path);
try{
		  nb=Double.parseDouble(route.getChildText("cons"))+ad;
			
			 //String st=df.format(nb);
				//nb=Double.parseDouble(st.replace(',', '.'));
			 
			 
			 route.getChild("cons").setText(nb.toString());
			 this.save(path);
}
catch(Exception e){System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");};
		
		 } finally {
	    l.unlock();
	}
	

	
}*/

/**
 * add a value to the tag "prod"
 * @param ad value to add
 */


/*
public synchronized  void addProd(Double ad){
	 route=this.read(path);
	 Double nb=Double.parseDouble(route.getChildText("prod"))+ad;

	 //String st=df.format(nb);
		//nb=Double.parseDouble(st.replace(',', '.'));	 
	 route.getChild("prod").setText(nb.toString());
	 this.save(path);

}
*/


/*
public synchronized  Double getCons(){
	 route=this.read(path);
	 return Double.parseDouble(route.getChildText("cons"));
}

public synchronized  Double getProd(){
	 route=this.read(path);
	 return Double.parseDouble(route.getChildText("prod"));
}

public synchronized  void setCons(Double ad) {
	route=this.read(path);
	 //String st=df.format(ad);
		//ad=Double.parseDouble(st.replace(',', '.'));
	 route.getChild("cons").setText(ad.toString());
	 this.save(path);
	
} */

/**
 * create a new tag in the XML file
 * @param name name of the new tag
 * @param cons value of the new tag

 */
	 
	 /*
public synchronized  void create(String name, Double cons) {
	route=this.read(path);
	if(route.getChild(name)==null)
	{      Element e = new Element(name);
		route.addContent(e);
	}
	if(name !=null)
	route.getChild(name).setText(cons.toString());

	 this.save(path);
}
*/

/**
 * initiate the XML file (0 in all tags)
 */

	 /*public synchronized void initiate() {
	route=this.read(path);
List<Element> ListeProcessus=route.getChildren();
Iterator<Element> itP= ListeProcessus.iterator();

//boucle pour la liste des processus
while(itP.hasNext())
    { Element baliseCour = itP.next();
if(baliseCour.getName()!="prod")
	baliseCour.setText("0.0");
this.save(path);


    }

}*/
}
