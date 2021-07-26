package decision;

import java.util.Vector;

//import java.util.Hashtable;

public class Alternative {

	private String id;
	//a vector taht contains the quantity value & the consumed cost (for each decision param)
	private Vector<DecisionParameter> decisionParameterVector;
	//private float cost;
	
	

	public Vector<DecisionParameter> getDecisionParameterVector() {
		return decisionParameterVector;
	}

	public void setDecisionParameterVector(
			Vector<DecisionParameter> decisionParameterVector) {
		this.decisionParameterVector = decisionParameterVector;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
