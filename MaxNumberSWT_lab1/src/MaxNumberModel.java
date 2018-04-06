//The Model performs all the calculations needed


public class MaxNumberModel {
	//Holds the value of the max number entered in the view
	
	private int maxNumber;
	
	public void findMaxNumber(int firstNumber, int secondNumber, int thirdNumber){
		maxNumber = Math.max(firstNumber, Math.max(secondNumber, thirdNumber));
	}
	
	public int getMaxNumber() {
		return maxNumber;
	}

}