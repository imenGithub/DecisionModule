package decision;

//import java.io.File;
import java.util.List;
import java.util.Vector;

import org.jdom.Element;
//import org.jdom.input.SAXBuilder;

import toolbox.XmlFileRW;

public class DecisionParametersFileRW extends XmlFileRW{
	
	public DecisionParametersFileRW(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	
	
	public Vector<DecisionParameter> readDecisionParameters()
	{
	   Vector<DecisionParameter> decisionParametersVector = new Vector<DecisionParameter>();
	   List<?> list = getRoot().getChildren("decisionParameter");
       for (int i = 0; i < list.size(); i++) {

		   Element node = (Element) list.get(i);
		   
		 //Creation of decision parameter object
	    	DecisionParameter dp = new DecisionParameter();
	    	dp.setName(node.getChildText("name"));
	    	dp.setWeight(Float.valueOf(node.getChildText("weight")));
	    	dp.setCostThreshold(Float.valueOf(node.getChildText("threshold")));
	    	//add decision parameter to the vector
	    	decisionParametersVector.add(dp);

		}
       
          //test lecture du vecteur decision Param
     		for(int i=0;i<decisionParametersVector.size();i++){
     			DecisionParameter p = (DecisionParameter) decisionParametersVector.elementAt(i);
     			System.out.println("Name : " + p.getName());
     			System.out.println("Weight : " + p.getWeight());
     			System.out.println("Threshold : " + p.getCostThreshold());
     			System.out.println("********* ");
     		}
     		return decisionParametersVector;
	 }


}
