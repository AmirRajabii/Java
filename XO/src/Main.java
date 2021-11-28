import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
		String t = "";
		int i = 0;
		Boolean turn = true;
		Boolean finish = true;
		while (i < 9) {

			if ((num[0] == num[1] && num[1] == num[2]) || (num[3] == num[4] && num[4] == num[5])
					|| (num[6] == num[7] && num[7] == num[8]) || (num[0] == num[3] && num[3] == num[6])
					|| (num[1] == num[4] && num[4] == num[7]) || (num[2] == num[5] && num[5] == num[8])
					|| (num[0] == num[4] && num[4] == num[8]) || (num[2] == num[4] && num[4] == num[6])) {
				System.out.println("-----------------------");
				System.out.println(num[0] + "\t" + num[1] + "\t" + num[2] + "\n" + num[3] + "\t" + num[4] + "\t"
						+ num[5] + "\n" + num[6] + "\t" + num[7] + "\t" + num[8]);
				System.out.println(t + " Win !!!!!!");
				finish = false;
				break;
			}

			if (turn == true) {
				t = "Firts Player";
			} else {
				t = "Second Player";
			}
			System.out.println(num[0] + "\t" + num[1] + "\t" + num[2] + "\n" + num[3] + "\t" + num[4] + "\t" + num[5]
					+ "\n" + num[6] + "\t" + num[7] + "\t" + num[8]);
			System.out.print(t + " Enter a Number 0--8 : ");
			int n = new Scanner(System.in).nextInt();

			switch (n) {
			case 0:
				if (num[0] != "0") {
					System.out.println(" 0 is already used , Try Again");
				} else {
					if (turn == true) {
						num[0] = "X";
					} else {
						num[0] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 1:
				if (num[1] != "1") {
					System.out.println(" 1 is already used , Try Again");
				} else {
					if (turn == true) {
						num[1] = "X";
					} else {
						num[1] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 2:
				if (num[2] != "2") {
					System.out.println(" 2 is already used , Try Again");
				} else {
					if (turn == true) {
						num[2] = "X";
					} else {
						num[2] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 3:
				if (num[3] != "3") {
					System.out.println(" 3 is already used , Try Again");
				} else {
					if (turn == true) {
						num[3] = "X";
					} else {
						num[3] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 4:
				if (num[4] != "4") {
					System.out.println(" 4 is already used , Try Again");
				} else {
					if (turn == true) {
						num[4] = "X";
					} else {
						num[4] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 5:
				if (num[5] != "5") {
					System.out.println(" 5 is already used , Try Again");
				} else {
					if (turn == true) {
						num[5] = "X";
					} else {
						num[5] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 6:
				if (num[6] != "6") {
					System.out.println(" 6 is already used , Try Again");
				} else {
					if (turn == true) {
						num[6] = "X";
					} else {
						num[6] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 7:
				if (num[7] != "7") {
					System.out.println(" 7 is already used , Try Again");
				} else {
					if (turn == true) {
						num[7] = "X";
					} else {
						num[7] = "O";
					}
					turn = !turn;
					i++;
				}
				break;
			case 8:
				if (num[8] != "8") {
					System.out.println(" 8 is already used , Try Again");
				} else {
					if (turn == true) {
						num[8] = "X";
					} else {
						num[8] = "O";
					}
					turn = !turn;
					i++;
				}
				break;

			default:
				System.out.println("Wrong Number");
				break;
			}
		}
		if (finish) {
			System.out.println("-----------------------");
			System.out.println("!!!! Draw !!!!");
		}
	}

}
