package decision.utilityFunctions;

//import java.util.Enumeration;
import java.util.Hashtable;

//import decision.selection.UtilityFunction;

public class UtilityFunctionsIndex {
	
	private Hashtable<String,String> UFindex;

	public UtilityFunctionsIndex()
	{
		UFindex= new Hashtable<String,String>();
		//******* correspondence between name of utility function/ java class name
		UFindex.put("Cobb Douglas", "decision.utilityFunctions.CobbDouglasUF");
		UFindex.put("Von Neumann Morgenstern", "decision.utilityFunctions.VonNeumannMorgensternUF");
		UFindex.put("Perfect Substitues", "decision.utilityFunctions.PerfectSubstitutesUF");
		UFindex.put("Perfect Complements", "decision.utilityFunctions.PerfectComplementsUF");
		
		
	}
	
	//getter & setter of the hashtable
	public Hashtable<String, String> getUFindex() {
		return UFindex;
	}

	public void setUFindex(Hashtable<String, String> uFindex) {
		UFindex = uFindex;
	}
	
	/**
	 * get the java class name of the considered utility function (from the Hashtable)
	 * 
	 * @param UFname
	 *          the name of the utility function
	 * @return
	 *   	the name of the java class of the considered utility function
	 */
	public String getUFClassName(String ufName)
	{
		//to display hashtable
		/*Enumeration names = UFindex.keys();
		String key;
		while(names.hasMoreElements()) {
		      key = (String) names.nextElement();
		      System.out.println("Key: " +key+ " & Value: " +
		      UFindex.get(key));
		}*/
		
		// get value at key UFname
	    System.out.println("Values at key UFname is:"+ UFindex.get(ufName)); 
		return UFindex.get(ufName);
		
	}
	
//	/**
//	 * get an instance by the java class name 
//	 * 
//	 * @param UFClassName
//	 *            the name of java class of the considered utility function
//	 * @return
//	 * 		an instance of the utility function (object)
//	 */
//	public UtilityFunction getUFInstanceByClassName(String UFClassName)
//	{
//		try{
//			Class c = Class.forName(UFClassName);
//			return (UtilityFunction)c.newInstance();
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	

}
