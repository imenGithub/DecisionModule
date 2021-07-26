package decision.selection;

import java.util.Hashtable;

public class SelectionIndex {
	
	private Hashtable<String,String> SelectionIndexTable;

	public SelectionIndex()
	{
		SelectionIndexTable= new Hashtable<String,String>();
		
		//******* correspondence between the type of the decision approach 
        //                  and the type of the selection manager
		SelectionIndexTable.put("decision.decisionApproaches.UtilityOrientedApproach", 
				"decision.selection.UtilitySelectionManager");
		
		//type: decision.decisionApproaches.UtilityOrientedApproach
		
		SelectionIndexTable.put("decision.decisionApproaches.SAapproach", 
				"decision.utilityFunctions.SAselectionManager");
		
		SelectionIndexTable.put("decision.decisionApproaches.GoalOrientedApproach",
				"decision.utilityFunctions.GoalSelectionManager");
	}
	
	public Hashtable<String, String> getSelectionIndexTable(){
		return SelectionIndexTable;
	}

	public void setSelectionIndexTable(Hashtable<String, String> selectionIndex) {
		SelectionIndexTable = selectionIndex;
	}
	

}
