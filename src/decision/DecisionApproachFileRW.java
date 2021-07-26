package decision;

//import java.util.List;

//import org.jdom.Element;
//import java.util.Vector;

//import org.jdom.Element;

import toolbox.XmlFileRW;

public class DecisionApproachFileRW extends XmlFileRW{
	
//	private Element root;
//	
//	public Element getRoot() {
//		return root;
//	}
//
//	public void setRoot(Element root) {
//		this.root = root;
//	}

	public DecisionApproachFileRW(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public String readDecisionApproach()
	{
		String chosenDecisionApproachName="";
		//List list = getRoot().getChildren("decisionApproach");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
		System.out.println("Name of the decision approach: " + getRoot().getChildText("name"));
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
		
		chosenDecisionApproachName = getRoot().getChildText("name");
		return chosenDecisionApproachName;
		
	}
		
		

}
