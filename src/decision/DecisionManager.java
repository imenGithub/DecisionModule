  package decision;
  
import java.util.Iterator;
//import java.util.List;
import java.util.Set;

import java.util.Vector;

//import org.jdom.Element;

import decision.decisionApproaches.DecisionApproachesIndex;
//import decision.decisionApproaches.UtilityOrientedApproach;
import decision.filtering.FilteringManager;
import decision.selection.SelectionIndex;
import decision.selection.SelectionManager;
import decision.selection.UtilitySelectionManager;
//import decision.selection.UtilityFunction;
//import decision.utilityFunctions.UtilityFunctionsIndex;

import toolbox.FilesInDirectoryCalculator;
//import toolbox.XmlFileRW;

/**
 * @author Imen
 * This class is the main class of the decision module
 * 
 */

public class DecisionManager {
	
	private DecisionApproachFileRW decisionApproachFileRW;
	
	private DecisionParametersFileRW decisionParametersFileRW;
	private Vector<DecisionParameter> decisionParametersVector;

	//for the reading of alternatives
	private AlternativeFileRW alternativeFileRW;
	private Vector<Alternative> alternativesVector;
	private Vector<Alternative> filteredAlternativesVector;
	
	
	public Vector<Alternative> getAlternativesVector() {
		return alternativesVector;
	}

	public void setAlternativesVector(Vector<Alternative> alternativesVector) {
		this.alternativesVector = alternativesVector;
	}

	private DecisionApproach decisionApproach;
	
	private FilteringManager filteringManager;
	private SelectionManager selectionManager;
	
	/**
	 * Basic constructor
	 * 
	 * @param decisionParametersFilePath
	 *            the path of the xml file that includes the decision parameters
	 * @param userPreferencesFilePath
	 *            the path of the xml file that contains the user preferences
	 * 				
	 */
	
	public DecisionManager (DecisionParametersFileRW decisionParametersFileRW, 
			DecisionApproachFileRW decisionApproachFileRW)
	{
		this.decisionParametersFileRW = decisionParametersFileRW;
		this.decisionApproachFileRW = decisionApproachFileRW;
		
		//Creation of the decision approach
		decisionApproach=new DecisionApproach();
		//Creation of the vector of decision parameters
		decisionParametersVector= new Vector<DecisionParameter>();
		//Reading of the decision parameters
		readDecisionParameters();
		
	}
	
	/**
	 * reads the decision parameters
	 * 
	 */
	public void readDecisionParameters()
	{					
		//Reading of the root element of the decision parameters xml file 
		decisionParametersFileRW.readRoot();
		//setting of the vector of decision parameters
		decisionParametersVector=decisionParametersFileRW.readDecisionParameters();
	}
	
	/**
	 * Setter of the decision parameters vector
	 * 
	 */
	public void setDecisionParametersVector(
			Vector<DecisionParameter> decisionParametersVector) {
		this.decisionParametersVector = decisionParametersVector;
	}
	
	/**
	 * Getter of the decision parameters vector
	 * 
	 */
	public Vector<DecisionParameter> getDecisionParametersVector() {
		return decisionParametersVector;
	}

	
	/**
	 * reads the chosen decision approach
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	public void readChosenDecisionApproach() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{				
		//reading of the chosen decision approach
		decisionApproachFileRW.readRoot();
		String chosenDecisionApproach = decisionApproachFileRW.readDecisionApproach();
		
		//get the type (class name) of decision approach
		DecisionApproachesIndex decisionApproachesIndex = new DecisionApproachesIndex();
		String decisionApprClassName="";
		decisionApprClassName=decisionApproachesIndex.getDecisionApproachClassName(chosenDecisionApproach);
		
		//create the decisionApproach object
		decisionApproach= getDecisionApproachInstanceByClassName(decisionApprClassName);
		//set the name of the decision approach (the name chosen by user)
		decisionApproach.setName(chosenDecisionApproach);
		
		System.out.println("Chosen decision approach => " + decisionApproach.getName());
	}
	
	/**
	 * get an instance by the type (java class name of the decision approach)
	 * 
	 * @param decisionApproachClassName
	 *            the name of the type (java class) of the considered decision approach
	 * @return
	 * 		an instance of the decision approach (object)
	 */
	public DecisionApproach getDecisionApproachInstanceByClassName(String decisionApproachClassName)
	{
		try{
			Class<?> c = Class.forName(decisionApproachClassName);
			return (DecisionApproach)c.newInstance();
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
	
	public void initializeAlternatives()
	{
		//creation of the vector of alternatives
		alternativesVector= new Vector<Alternative>();
	}
	
	
	public int getAlternativesTotalNumber(String alternativesDirectoryPath) throws Exception
	{
		FilesInDirectoryCalculator filesCalculator = new FilesInDirectoryCalculator();
		int nb_files=filesCalculator.calculateFilesNumber(alternativesDirectoryPath);
		System.out.println("");
		System.out.println("**** The number of alternatives = " + nb_files);
		return nb_files;
		
	}
	
	
	/**
	 * reads the set of alternatives
	 * 
	 * @param alternativesFilePath
	 *            the path of the xml file that contains the alternatives description
	 */
	public void readAlternative(AlternativeFileRW alternativeFileRW)
	{					
		this.alternativeFileRW=alternativeFileRW;
		
		//get the root of the considered alternative file
		alternativeFileRW.readRoot();
		Alternative alternative =this.alternativeFileRW.readAlternative();
		alternativesVector.add(alternative);
		
	}
	
	
	
	public void initializeFiltering()
	{
		filteringManager = new FilteringManager();
		filteredAlternativesVector = new Vector<Alternative>();
		
	}
	/*
	 * filters the set of alternatives
	 *
	 * @param alternativesFilePath
	 *            the path of the xml file that contains the alternatives description
	 */
	public void filterAlternatives()
	{	
		System.out.println("Filtering Phase...");
		filteredAlternativesVector=filteringManager.filter(alternativesVector);
		//this.setAlternativesVector(filteringManager.filter(this.getAlternativesVector()));
		
	}
	
	
	
	public void initializeSelection()
	{	
		selectionManager = new UtilitySelectionManager();
		
	}
	/**
	 * selects the most suitable alternative
	 *
	 * @param alternativesFilePath
	 *            the path of the xml file that contains the alternatives description
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void selectBestAlternative() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{	
		System.out.println("");
		System.out.println("Selection Phase...");
		
		//Get the type of the selection manager
		String selectionManagerType="";
		
		SelectionIndex selectionIndex = new SelectionIndex();
		Set<?> keys = selectionIndex.getSelectionIndexTable().keySet();
		Iterator<?> it = keys.iterator();
		boolean exist = false;
		while (it.hasNext() && !exist){
			
			String key = (String) it.next();
			System.out.println("key : " + key);
			
			String value = selectionIndex.getSelectionIndexTable().get(key);
			System.out.println("value : " + value);
			
			Class<?> typeDecisionApproach = Class.forName(key);
			
			//test
			System.out.println("######## " + (typeDecisionApproach.isInstance(decisionApproach)));
			
			if (typeDecisionApproach.isInstance(decisionApproach))
			{
				selectionManagerType=value;
				exist=true;
			}

		}
		
		System.out.println("selection manager type => " + selectionManagerType);
		
		Class<?> c = Class.forName(selectionManagerType);
		selectionManager= (SelectionManager)c.newInstance();
		
		//select the most suitable alternative
		Alternative bestAlt=selectionManager.select(filteredAlternativesVector,
				decisionParametersVector);
		
		System.out.println("Best Alternative Id ==> " + bestAlt.getId());
		
	}
	
    public void handle() throws Exception
    {
    	//Creation of an instance alternativesFileRW 
    	AlternativeFileRW alternativeFileRW = new AlternativeFileRW("");
    	
    	//Create alternativesVector of dm
    	this.initializeAlternatives();

        int nb_files = this.getAlternativesTotalNumber("./decision_input/alternatives");
    			
    	//Reading of each alternative file (----> when there is an input: a new set of alternatives )
    	for(int i=1; i<=nb_files;i++)
    	{
    		//change the path of alternativesFileRW
    		String newPath= "./decision_input/alternatives/alternative"+i+".xml";
    		System.out.println("NEW PATH ====> " + newPath);
    		alternativeFileRW.setPath(newPath);
    		this.readAlternative(alternativeFileRW);
    	}
    			
    	//Test reading of alternatives 
    	System.out.println("");
    	System.out.println("***** Begin Test: Alternatives Reading *****");
    	for (int i=0;i<this.getAlternativesVector().size();i++)
    	{
    		Alternative a = this.getAlternativesVector().elementAt(i);
    						
    		System.out.println("Alternative " + (i+1));
    		System.out.println(" Id : " + a.getId());
    						
    		for (int j=0;j<a.getDecisionParameterVector().size();j++)
    		{
    			DecisionParameter d = a.getDecisionParameterVector().get(j);
    			System.out.println("param name" + (j+1) +" : " + d.getName());
    			System.out.println("param value" + (j+1) +" : " + d.getAltValue());
    			System.out.println();
    		}
    						
    	}
    					
    	System.out.println("***** End Test: Alternatives Reading *****");
    	System.out.println("");

    	//Reading of the decision approach chosen by the user
    	this.readChosenDecisionApproach();
    			
    	//filtering of alternatives
    	this.initializeFiltering();
    	this.filterAlternatives();
    			
    	//selection of the most suitable alternative
    	this.initializeSelection();
    	this.selectBestAlternative();
    	
    }

	
	
	
	

}
