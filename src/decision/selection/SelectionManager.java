package decision.selection;

import java.util.Vector;

import decision.Alternative;
import decision.DecisionParameter;

public interface SelectionManager {
	
	public Alternative select(Vector<Alternative> alternativesVector, Vector<DecisionParameter>
	decisionParametersVector);
	

}
