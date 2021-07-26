package test;

//import java.util.ArrayList;

//import org.jdom.Element;
//import org.w3c.dom.NodeList;
//import toolbox.FilesInDirectoryCalculator;
//import toolbox.XmlFileRW;
//import decision.AlternativeFileRW;
import decision.DecisionManager;
import decision.DecisionApproachFileRW;
//import decision.DecisionParametersFileRW;
import decision.DecisionParametersFileRW;

/**
 * @author Imen
 * This is a class test for the decision module
 * 
 */

public class test {
	
	public static void main(String args[]) throws Exception
	{
		//input files path
		String decisionParametersFilePath = "./decision_input/decisionParameters.xml";
		String decisionApproachFilePath = "./decision_input/decisionApproach.xml";
		
		//Creation of an instance decisionApproachFileRW
		DecisionApproachFileRW decisionApproachFileRW =new DecisionApproachFileRW(decisionApproachFilePath);
		
		//Creation of an instance decisionParametersFileRW
		DecisionParametersFileRW decisionParametersFileRW=new DecisionParametersFileRW(decisionParametersFilePath);
		
		//Creation of an instance of DecisionManager (includes the reading of the decision parameters)
		DecisionManager dm = new DecisionManager(decisionParametersFileRW, decisionApproachFileRW);
		
		//***** trigger (Event)
		dm.handle();
			
	}

}

//**** Test 
//System.out.println("hhhh " + (dm instanceof DecisionManager));
//Class
//Class<?> c = Class.forName("decision.DecisionManager");
//System.out.println("######## " + (c.isInstance(dm)));
