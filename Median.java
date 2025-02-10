
//Using Pane and Arrays
import javax.swing.JOptionPane;
import java.util.Arrays;

public class Median {

	public static void main(String[] args) {

		String amount = JOptionPane.showInputDialog("Give me the amount of scores");//The number of scores is asked
		if (amount == null) JOptionPane.showMessageDialog(null, "The user closed the program", "Error", JOptionPane.ERROR_MESSAGE);//The user closes the program
		else {
			try {
				int numberScores = Integer.parseInt(amount);//The amount of scores is set as an integer
				if (numberScores <= 0) {
					JOptionPane.showMessageDialog(null, "It's not a natural number (greater than 0)", "Error", JOptionPane.ERROR_MESSAGE);//There are no negative Arrays
				}else {
					float [] scores = new float[numberScores];//An array is created with the same size as the amount of scores

					//loop to ask for all the values within the array
					for(int i = 0; i<scores.length;i++) {
						String score = JOptionPane.showInputDialog("Give me the score " + (i+1));//Window to ask for the values
						try {
							scores[i] = Float.parseFloat(score);//The values are set as Floats

							//Validation of real scores
							if(scores[i] < 0 || scores[i]>10) {
								i--;
								JOptionPane.showMessageDialog(null, "There value is not a valid score", "Error", JOptionPane.ERROR_MESSAGE);//The score must be a number between 0-10
							}

							//Validation that the scores are actually numbers
						}catch (Exception e){
							i--;
							JOptionPane.showMessageDialog(null, "The value is not a number", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}

					//Using the method sort from Arrays
					Arrays.sort(scores);
					int numberMedians = (scores.length/2)%2;//The median changes if the length is odd or even

					//The length is even
					if(numberMedians != 1) {
						JOptionPane.showMessageDialog(null, "The median is " + ((scores[scores.length/2]+scores[scores.length/2+1])/2), "2 Median", JOptionPane.DEFAULT_OPTION);

						//The length is odd
					}else {
						JOptionPane.showMessageDialog(null, "The median is " + scores[scores.length/2], "1 Median", JOptionPane.DEFAULT_OPTION);
					}


				}

				//If the number of scores cannot be set as an Integer, the exception is called
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "It's not a natural number (greater than 0)", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}


	}


}
