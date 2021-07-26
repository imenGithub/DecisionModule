package decision.utilityFunctions;

import java.util.Vector;

import decision.selection.UtilityFunction;

public class PerfectSubstitutesUF implements UtilityFunction{

	@Override
	public float calculateUtility(Vector<Float> quantityVect,
			Vector<Float> weightVect) {
        float u = 0;
		
		for(int i=0; i<quantityVect.size(); i++)
		//	for(int i=0; i<weightVect.size(); i++)
		{
			System.out.println(" --------------- param " + (i+1));
			System.out.println(" weight : " + weightVect.elementAt(i));
			System.out.println(" quantity : " + quantityVect.elementAt(i));
			u= (float) u + weightVect.elementAt(i) * quantityVect.elementAt(i);
		}
		
		return u;
//		float u = 0;
//		
//		for(int i=0; i<quantityVect.size(); i++)
//		{
//			u= u + weightVect.get(i) ;
//		}
//		return 0;
	}

}
