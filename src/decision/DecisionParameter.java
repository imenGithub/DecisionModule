package decision;

public class DecisionParameter {
	
	private String name;
	private float weight;
	private float costThreshold;
	
	private float altValue;
	private float altCost;
	

	//***** getters & setters *****/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getCostThreshold() {
		return costThreshold;
	}
	public void setCostThreshold(float costThreshold) {
		this.costThreshold = costThreshold;
	}
	

	
	public float getAltValue() {
		return altValue;
	}
	public void setAltValue(float altValue) {
		this.altValue = altValue;
	}
	
	public float getAltCost() {
		return altCost;
	}
	public void setAltCost(float altCost) {
		this.altCost = altCost;
	}
	
	
	

}
