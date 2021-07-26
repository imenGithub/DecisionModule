package decision.selection;

//import java.util.List;
import java.util.Vector;

//import org.jdom.Element;

import decision.Alternative;
import decision.DecisionParameter;
import decision.utilityFunctions.IndirectUF;
import decision.utilityFunctions.UtilityFunctionsIndex;

public class UtilitySelectionManager implements SelectionManager{
	
	Vector<Float> valuesVector;
	Vector<Float> weightsVector;
	UtilityFunctionXMLFileR utilityFunctionXMLFileR;
	
	public UtilitySelectionManager()
	{
		valuesVector = new Vector<Float>();
		weightsVector = new Vector<Float>();
		//String utilityFunctionXMLFileRpath = "./decision_input/utilityFunction.xml";
		String utilityFunctionXMLFileRpath = "./decision_input/utilityFunction2.xml";
		utilityFunctionXMLFileR = new UtilityFunctionXMLFileR(utilityFunctionXMLFileRpath);
		
	}
	
	public Alternative select(Vector<Alternative> alternativesVector, Vector<DecisionParameter>
			decisionParametersVector)
	{
		String ufClassName="";
		System.out.println("UtilitySelectionManager selection");
		
		//read utility function type (simple/combined)
		utilityFunctionXMLFileR.readRoot();
		String utilityFunctionType = utilityFunctionXMLFileR.readChosenUtilityFunctionType();
		System.out.println("type => " + utilityFunctionType);
		
		//initialisation ( => must be modified!!)
		Alternative bestAlternative = null;
		
		if(utilityFunctionType.equals("simple"))
		{
			String utilityFunctionName = utilityFunctionXMLFileR.readSimpleUtilityFuntion();
			System.out.println("name => " + utilityFunctionName);
			
			//get the class name of the considered utility function
			UtilityFunctionsIndex ufIndex = new UtilityFunctionsIndex();
			ufClassName=ufIndex.getUFClassName(utilityFunctionName);
			
			UtilityFunction uf;
			//uf=getUFInstanceByClassName("decision.utilityFunctions.CobbDouglasUF");
			uf=getUFInstanceByClassName(ufClassName);
		
			float utilityValue;
			float maxUtility = -10000;
			
			for(int i=0;i<alternativesVector.size();i++)
			{
				System.out.println("// Alternative " + alternativesVector.elementAt(i).getId());
				//for(int j=0;j<alternativesVector.get(i).getDecisionParameterVector().size();j++)
				
				for(int j=0;j<alternativesVector.elementAt(i).getDecisionParameterVector().size();j++)
				{
					System.out.println("////////////// value => " +
							alternativesVector.get(i).getDecisionParameterVector().get(j).getAltValue());
					valuesVector.add(alternativesVector.get(i).getDecisionParameterVector().get(j).getAltValue());
					
//					System.out.println("////////////// weight -1- => " +
//							decisionParametersVector.get(j).getValue());
					
					for(int k=0;k<decisionParametersVector.size();k++)
					{
						if(decisionParametersVector.get(k).getName().equals
								(alternativesVector.get(i).getDecisionParameterVector().get(j).getName()))
						{
							System.out.println("////////////// weight => " +
									decisionParametersVector.get(k).getWeight());
							weightsVector.add(decisionParametersVector.get(k).getWeight());
						}
					}
				}
				
				System.out.println("Testtttt");
				System.out.println("size valuesVect : " + valuesVector.size());
				System.out.println("size weightsVector : " + weightsVector.size());
				
				//calculate the utility of the alternative
				utilityValue = uf.calculateUtility(valuesVector, weightsVector);
				if(utilityValue>=maxUtility)
				{
					maxUtility=utilityValue;
					bestAlternative=alternativesVector.elementAt(i);
				}
	
				System.out.println("Utility value of the alternative "+ alternativesVector.elementAt(i).getId() + " is : "+utilityValue);
				//supp elem vect
					for(int t=0;t<valuesVector.size();t++)
					{
						valuesVector.removeAllElements();
						weightsVector.removeAllElements();
					}
				
			}
				
			
		}
		else
		{
			//********************* Combined utility ***********************************/
			Vector<String> VectorUFname = utilityFunctionXMLFileR.readCombinedUtilityFuntion();
			
			String utilityFunctionName1 = VectorUFname.elementAt(0);
			System.out.println("name 1 => " + utilityFunctionName1);
			
			String utilityFunctionName2 = VectorUFname.elementAt(1);
			System.out.println("name 2 => " + utilityFunctionName2);
			
			
			//get the class name of the simple utility function (name 1)
			UtilityFunctionsIndex ufIndex = new UtilityFunctionsIndex();
			ufClassName=ufIndex.getUFClassName(utilityFunctionName1);
			
			UtilityFunction uf;
			//uf=getUFInstanceByClassName("decision.utilityFunctions.CobbDouglasUF");
			uf=getUFInstanceByClassName(ufClassName);
			
			IndirectUF indirectUF = new IndirectUF();
			bestAlternative=indirectUF.getBestAlternative(alternativesVector, decisionParametersVector, uf);
			
		}
			
		return bestAlternative;
	}
	
	/**
	 * get an instance by the java class name 
	 * 
	 * @param UFClassName
	 *            the name of java class of the considered utility function
	 * @return
	 * 		an instance of the utility function (object)
	 */
	public UtilityFunction getUFInstanceByClassName(String UFClassName)
	{
		try{
			Class<?> c = Class.forName(UFClassName);
			return (UtilityFunction)c.newInstance();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
