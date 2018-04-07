/**
 * The class serves to store data.
 * @author NotePad
 */


public class MaxNumberModel {
	
	/** Property - Maximum number */
	private int maxNumber;
	
	/** Method calculates the maximum number.
	 * @param firstNumber
	 * @param secondNumber
	 * @param thirdNumber
	 */
	public void findMaxNumber(int firstNumber, int secondNumber, int thirdNumber){
		maxNumber = Math.max(firstNumber, Math.max(secondNumber, thirdNumber));
	}
	/** Method returns maximum number.
	 * @return maximum number
	 */
	public int getMaxNumber() {
		return maxNumber;
	}

}