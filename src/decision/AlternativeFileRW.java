package decision;

import java.util.List;
import java.util.Vector;

import org.jdom.Attribute;
import org.jdom.Element;

import toolbox.XmlFileRW;

public class AlternativeFileRW extends XmlFileRW{
	
	public AlternativeFileRW(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
//	/**
//	 * get the decision Parameter object named "name"
//	 * 
//	 * @param name
//	 *      the name of the decision parameter
//	 * @return
//	 * 		the decision Parameter object
//	 */
//	
//	public DecisionParameter getDecisionParameterByName(String name, Vector <DecisionParameter> decisionParametersVector)
//	{
//		for (int i=0; i<decisionParametersVector.size();i++)
//		{
//			if(decisionParametersVector.get(i).getName().equals(name))
//				return decisionParametersVector.get(i);
//		}
//		System.out.println("There is no decision parameter that has the name : " + name);
//		return null;
//		
//	}
	
	public Alternative readAlternative()
	{
		
		//create instance of Alternative
		Alternative alternative = new Alternative();
		
		Attribute attb = getRoot().getAttribute("id");
		alternative.setId(attb.getValue());
		System.out.println( "Alternative ID ==== " + attb.getValue());
		
		Element node = getRoot().getChild("decisionParameters");
		
		//Vector of decision parameters (attribute of the alternative)
		Vector<DecisionParameter> decisionParamVect = new Vector<DecisionParameter>();
		
		List<?> list = node.getChildren("decisionParameter");
		
		
	    for (int i = 0; i < list.size(); i++) {
	    	
	    	DecisionParameter decisionParam = new DecisionParameter();
	    	Element p = (Element) list.get(i);

	    	//read the name of the decision parameter
	    	System.out.println( "Name => " + p.getChildText("name"));
	    	decisionParam.setName(p.getChildText("name"));
	    	//DecisionParameter decisionParam = this.getDecisionParameterByName(p.getChildText("name"), decisionParametersVector);
	    	
	    	//read the value of the decision parameter
	    	System.out.println( "Value => " + p.getChildText("value"));
	    	decisionParam.setAltValue(Float.parseFloat(p.getChildText("value")));
	    	
	    	//read the cost (consumed by the alternative) of the decision parameter
	    	System.out.println( "cost => " + p.getChildText("cost"));
	    	decisionParam.setAltCost(Float.parseFloat(p.getChildText("cost")));
	    	
	    	decisionParamVect.add(decisionParam);
	    	
	    }
	    alternative.setDecisionParameterVector(decisionParamVect);
		return alternative;
		
	}

	
}
