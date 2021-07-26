package decision.selection;

import java.util.Vector;

import toolbox.XmlFileRW;

public class UtilityFunctionXMLFileR extends XmlFileRW{

	public UtilityFunctionXMLFileR(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	public String readChosenUtilityFunctionType()
	{
		 String type = getRoot().getAttribute("type").getValue();
		 return type;
	}
	
	public String readSimpleUtilityFuntion()
	{
		String UFname=getRoot().getChildText("name");
		return UFname;
		
	}
	
	public Vector<String> readCombinedUtilityFuntion()
	{
		Vector<String> VectorUFname=new Vector<String>();
		
		String UFname=getRoot().getChildText("name1");
		VectorUFname.add(UFname);
		UFname=getRoot().getChildText("name2");
		VectorUFname.add(UFname);
		return VectorUFname;
		
	}

}
