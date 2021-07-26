package decision.utilityFunctions;

import java.util.Vector;

import decision.selection.UtilityFunction;

public class PerfectComplementsUF implements UtilityFunction{

	@Override
	public float calculateUtility(Vector<Float> quantityVect,
			Vector<Float> weightVect) {
	
		float u = 100000000;
		
		for(int i=0; i<quantityVect.size(); i++)
		//	for(int i=0; i<weightVect.size(); i++)
		{
			System.out.println(" --------------- param " + (i+1));
			System.out.println(" weight : " + weightVect.elementAt(i));
			System.out.println(" quantity : " + quantityVect.elementAt(i));
			
			System.out.println((weightVect.elementAt(i) * quantityVect.elementAt(i)));
			if ((weightVect.elementAt(i) * quantityVect.elementAt(i)) < u)
				u= weightVect.elementAt(i) * quantityVect.elementAt(i);
		}
		return u;
	}

}
