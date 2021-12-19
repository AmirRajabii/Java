import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import Business.UserScore;
import Business.Security;


public class Main {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String time = dtf.format(now);
		String username="";
		boolean chk=false;
		UserScore userAndScore = new UserScore();
		Security security = new Security();
		while (!chk) {		
		System.out.println("1 - Login ");		
		System.out.println("2 - Create Account ");
		System.out.println("------------------");
		System.out.print("Enter 1 or 2 : ");
		byte menuNumber = new Scanner(System.in).nextByte();
		if(menuNumber==1) {
			System.out.print("Please Enter Your UserName : ");
			 username=new Scanner(System.in).next();
			System.out.print("Please Enter Your PassWord : ");
			String Password=new Scanner(System.in).next();
			if(userAndScore.fncChekLogin(username,security.encryptThisString(Password))) {
				System.out.println("! Success Login Please Wait Game is Loading !");
				System.out.println("------------------------");
				chk=true;
			}
			else {
				System.out.println("! Faild Login !");
				System.out.println("------------------------");
			}
		}
		else if (menuNumber==2) {
			System.out.print("Please Enter Your FirstName : ");
			String fistname=new Scanner(System.in).next();
			System.out.print("Please Enter Your LastName : ");
			String lastname=new Scanner(System.in).next();
			System.out.print("Please Enter Your UserName : ");
			 username=new Scanner(System.in).next();
			System.out.print("Please Enter Your PassWord : ");
			String Password=new Scanner(System.in).next();
			if(userAndScore.fncAddName(fistname, lastname, username, security.encryptThisString(Password))) {
				System.out.println("! User Created Please Wait Game is Loading !");
				System.out.println("------------------------");
				chk=true;
			}
				else {
					System.out.println("! User Not Created !");
					System.out.println("------------------------");
				}
			}
			
		else {
		}
	}
		try
		{
		    Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("---------------------------");
		
		System.out.println("1 - Start Game ");		
		System.out.println("2 - Show Scores ");
		System.out.println("------------------");
		System.out.print("Enter 1 or 2 : ");
		byte menuNumber = new Scanner(System.in).nextByte();
		if(menuNumber==1) {
			
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
			if(userAndScore.fncAddScore(username,Integer.toString(score) , time)) {
				System.out.println("! Your Score Is Saved !");
				System.out.println("-----------------------------");
			}
			else {
				System.out.println("! Your Score Is Not Saved !");
				System.out.println("-----------------------------");
			}
		}
		else if(menuNumber==1) {
			System.out.println("------ Score List ------");
			userAndScore.fncScoreList();
		}
		else {
			System.out.println("Wrong Number");
		}
	}
}

