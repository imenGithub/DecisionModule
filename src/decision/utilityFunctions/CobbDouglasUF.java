package decision.utilityFunctions;

import java.util.Vector;

import decision.selection.UtilityFunction;

public class CobbDouglasUF implements UtilityFunction{
	
	
	public float calculateUtility(Vector<Float> quantityVect, Vector<Float> weightVect)
	{
		float u = 1;
		
		for(int i=0; i<quantityVect.size(); i++)
		{
			u= (float) (u* (Math.pow(quantityVect.elementAt(i), weightVect.elementAt(i)))) ;
		}
		
		return u;
		
	}

//	@Override
//	public void calculateUtility() {
//		// TODO Auto-generated method stub
//		
//		System.out.println(" Test instance Cobb Douglas succeeded :) ");
//		
//	}

}
