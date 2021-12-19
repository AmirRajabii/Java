import java.util.Random;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		
		String[] Amalgar = { "+", "-", "*", "/" };
		Random generator = new Random();
		int score=0;
		while(true) {
		int rndNumber1 = generator.nextInt(20);
		int rndNumber2 = generator.nextInt(20);
		int rndAmalgar = generator.nextInt(4);
		System.out.println(rndNumber1 + " " + Amalgar[rndAmalgar] + " " + rndNumber2 + " = ? ");
		int correctAnswer = 0;
		switch (Amalgar[rndAmalgar]) {
		case "+":
			correctAnswer = rndNumber1 + rndNumber2;
			break;
		case "-":
			correctAnswer = rndNumber1 - rndNumber2;
			break;
		case "*":
			correctAnswer = rndNumber1 * rndNumber2;
			break;
		case "/":
			correctAnswer = rndNumber1 / rndNumber2;
			break;
		}
		 
		System.out.print("Please Enter Your Answer : ");
		int userAnswer=new Scanner(System.in).nextInt();	
		if(userAnswer==correctAnswer) {
			score++;
			System.out.println("! Correct Answer !");
			System.out.println("-------------------");
		}
		else {
			System.out.println("! Wrong Answer !");
			System.out.println("-------------------");
			break;
		}
		}
		System.out.println("Your Score is : "+score);
	}
}
