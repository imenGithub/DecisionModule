package decision.utilityFunctions;

import java.util.Vector;

import decision.Alternative;
import decision.DecisionParameter;
import decision.selection.UtilityFunction;

public class IndirectUF {
	
	public Alternative getBestAlternative(Vector<Alternative> alternativesVector, 
			Vector<DecisionParameter> decisionParametersVector, UtilityFunction uf)
	{
		Alternative bestAlternative=null;
		//altVect: the set of alternatives that does not exceed the cost thresholds of the parameters
		Vector<Alternative> ValidAltVect = new Vector<Alternative>();
		
		Boolean validAlt;
		int j;
		
		System.out.println("Test ----> nb alt : " + alternativesVector.size());
		
		for(int i=0;i<alternativesVector.size();i++)
		{
			System.out.println("// Alternative " + alternativesVector.elementAt(i).getId());
			validAlt = true;
			
			j=0;
			while(validAlt && j<alternativesVector.elementAt(i).getDecisionParameterVector().size())
			{
				System.out.println("////////////// Alt cost => " +
						alternativesVector.get(i).getDecisionParameterVector().get(j).getAltCost());
				
				if(alternativesVector.get(i).getDecisionParameterVector().get(j).getAltCost()>
				        decisionParametersVector.get(j).getCostThreshold())
				{
					validAlt=false;
					System.out.println("Not valid alt");
				}
				j++;
			}

			
//			for(int j=0;j<alternativesVector.elementAt(i).getDecisionParameterVector().size();j++)
//			{
//				System.out.println("////////////// Alt cost => " +
//						alternativesVector.get(i).getDecisionParameterVector().get(j).getAltCost());
//				//valuesVector.add(alternativesVector.get(i).getDecisionParameterVector().get(j).getAltValue());
//				
//				
//				for(int k=0;k<decisionParametersVector.size();k++)
//				{
//					if(alternativesVector.get(i).getDecisionParameterVector().get(j).getAltCost()>
//					    decisionParametersVector.get(k).getCostThreshold())
//					
//					{
//						validAlt=false;
//						System.out.println("Not valid alt");
//						break;
//					}
//				}
//				
//			}
			
			if(validAlt)
			{
				//ValidAltVect.add(alternativesVector.elementAt(i));
				System.out.println("valid alt");
				ValidAltVect.add(alternativesVector.elementAt(i));
			}
			
			
		}
		
		//ValidAltVect: the vector of valid alternatives (their costs <= threshold)
		
		float utilityValue;
		float maxUtility = -10000;
		
		Vector<Float> valuesVector= new Vector<Float>();
		Vector<Float> weightsVector= new Vector<Float>();
		
		for(int i=0;i<ValidAltVect.size();i++)
		{
			System.out.println("// Alternative " + ValidAltVect.elementAt(i).getId());
			
			for(int d=0;d<ValidAltVect.elementAt(i).getDecisionParameterVector().size();d++)
			{
				System.out.println("////////////// value => " +
						ValidAltVect.get(i).getDecisionParameterVector().get(d).getAltValue());
				valuesVector.add(ValidAltVect.get(i).getDecisionParameterVector().get(d).getAltValue());
				
				
				for(int k=0;k<decisionParametersVector.size();k++)
				{
					if(decisionParametersVector.get(k).getName().equals
							(ValidAltVect.get(i).getDecisionParameterVector().get(d).getName()))
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
				bestAlternative=ValidAltVect.elementAt(i);
			}

			System.out.println("Utility value of the alternative "+ ValidAltVect.elementAt(i).getId()+ 
					" is : "+utilityValue);
			//supp elem vect
				for(int t=0;t<valuesVector.size();t++)
				{
					valuesVector.removeAllElements();
					weightsVector.removeAllElements();
				}
			
		}
		
		return bestAlternative;
		
	}

}
