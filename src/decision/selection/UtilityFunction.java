package decision.selection;

import java.util.Vector;

//import java.util.List;

//import decision.DecisionParameter;

public interface UtilityFunction{ 
	
	public float calculateUtility(Vector<Float> quantityVect, Vector<Float> weightVect);
	
	
	//private String name;

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/
	
	//public abstract List<Double> getDecisionParametersQuantities(); 
	
	//public abstract List<Double> getDecisionParametersWeights();
	//public abstract List<DecisionParameter> getCoefficients(); 

}
