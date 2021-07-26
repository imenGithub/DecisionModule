package decision.decisionApproaches;

import java.util.Hashtable;

public class DecisionApproachesIndex {
	
	private Hashtable<String,String> approachesIndex;
	

	public DecisionApproachesIndex()
	{
		approachesIndex= new Hashtable<String,String>();
		//******* correspondence between name of utility function/ type (java class name)
		approachesIndex.put("Situation Actions Approach", "decision.decisionApproaches.SAapproach");
		approachesIndex.put("Goal Oriented Approach", "decision.decisionApproaches.GoalOrientedApproach");
		approachesIndex.put("Utility Oriented Approach", "decision.decisionApproaches.UtilityOrientedApproach");
		
	}
	
	//getter & setter of the hashtable
	public Hashtable<String, String> getAppIndex() {
		return approachesIndex;
	}

	public void setAppIndex(Hashtable<String, String> appIndex) {
		this.approachesIndex = appIndex;
	}
	
	/**
	 * get the java class name of the considered decision approach (from the Hashtable)
	 * 
	 * @param UFname
	 *          the name of the utility function
	 * @return
	 *   	the name of the java class of the considered utility function
	 */
	public String getDecisionApproachClassName(String chosenDecisionApproach)
	{		
		// get value at key approachName
	    System.out.println("Values at key UFname is:"+ approachesIndex.get(chosenDecisionApproach)); 
		return approachesIndex.get(chosenDecisionApproach);
		
	}

}
