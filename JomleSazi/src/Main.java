import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random generator = new Random();
		String[] zamayer = { "Man ", "To ", "Oo ", "Ma ", "Shoma ", "Anha " };
		// ------ Afaal ------
		String[] AfaalKhordan = { "Khordam ", "Khordi ", "Khord ", "Khordim ", "Khordid ", "Khordand " };
		String[] AfaalRaftan = { "Raftam ", "Rafti ", "Raft ", "Raftim ", "Raftid ", "Raftand " };
		String[] AfaalKharidn = { "Kharidm ", "Kharidi ", "Kharid ", "Kharidim ", "Kharidid ", "Kharidand " };
		String[] AfaalDidn = { "Didm ", "Didi ", "Did ", "Didim ", "Didid ", "Didand " };
		// ------ Kalamat ------
		String[] KlmtKhordan = { "Qaza ", "Sham ", "Nahar ", "Kabab ", "Pitza " };
		String[] KlmtRaftan = { "Be Park ", "Be Madrese ", "Be SareKar ", "Be Bashgah ", "Be Daneshgah " };
		String[] KlmtKharidn = { "Lebas ", "Ketab ", "Kafsh ", "Shalvar ", "Kapshan " };
		String[] KlmtDidn = { "Film ", "Serial ", "Mostanad ", "Cartoon ", "Video Amozeshi " };
		// ------

		int rndZamir = generator.nextInt(6);
		int rndFel = generator.nextInt(4) + 1;
		int rndKlmt = generator.nextInt(5);

		switch (rndZamir) {
		case 0:
			switch (rndFel) {
			case 1:
				System.out.println(zamayer[0] + KlmtKhordan[rndKlmt] + AfaalKhordan[0]);
				break;
			case 2:
				System.out.println(zamayer[0] + KlmtRaftan[rndKlmt] + AfaalRaftan[0]);
				break;
			case 3:
				System.out.println(zamayer[0] + KlmtKharidn[rndKlmt] + AfaalKharidn[0]);
				break;
			case 4:
				System.out.println(zamayer[0] + KlmtDidn[rndKlmt] + AfaalDidn[0]);
				break;
			}
			break;
		case 1:
			switch (rndFel) {
			case 1:
				System.out.println(zamayer[1] + KlmtKhordan[rndKlmt] + AfaalKhordan[1]);
				break;
			case 2:
				System.out.println(zamayer[1] + KlmtRaftan[rndKlmt] + AfaalRaftan[1]);
				break;
			case 3:
				System.out.println(zamayer[1] + KlmtKharidn[rndKlmt] + AfaalKharidn[1]);
				break;
			case 4:
				System.out.println(zamayer[1] + KlmtDidn[rndKlmt] + AfaalDidn[1]);
				break;
			}
			break;
		case 2:
			switch (rndFel) {
			case 1:
				System.out.println(zamayer[2] + KlmtKhordan[rndKlmt] + AfaalKhordan[2]);
				break;
			case 2:
				System.out.println(zamayer[2] + KlmtRaftan[rndKlmt] + AfaalRaftan[2]);
				break;
			case 3:
				System.out.println(zamayer[2] + KlmtKharidn[rndKlmt] + AfaalKharidn[2]);
				break;
			case 4:
				System.out.println(zamayer[2] + KlmtDidn[rndKlmt] + AfaalDidn[2]);
				break;
			}
			break;
		case 3:
			switch (rndFel) {
			case 1:
				System.out.println(zamayer[3] + KlmtKhordan[rndKlmt] + AfaalKhordan[3]);
				break;
			case 2:
				System.out.println(zamayer[3] + KlmtRaftan[rndKlmt] + AfaalRaftan[3]);
				break;
			case 3:
				System.out.println(zamayer[3] + KlmtKharidn[rndKlmt] + AfaalKharidn[3]);
				break;
			case 4:
				System.out.println(zamayer[3] + KlmtDidn[rndKlmt] + AfaalDidn[3]);
				break;
			}

			break;
		case 4:
			switch (rndFel) {
			case 1:
				System.out.println(zamayer[4] + KlmtKhordan[rndKlmt] + AfaalKhordan[4]);
				break;
			case 2:
				System.out.println(zamayer[4] + KlmtRaftan[rndKlmt] + AfaalRaftan[4]);
				break;
			case 3:
				System.out.println(zamayer[4] + KlmtKharidn[rndKlmt] + AfaalKharidn[4]);
				break;
			case 4:
				System.out.println(zamayer[4] + KlmtDidn[rndKlmt] + AfaalDidn[4]);
				break;
			}

			break;
		case 5:
			switch (rndFel) {
			case 1:
				System.out.println(zamayer[5] + KlmtKhordan[rndKlmt] + AfaalKhordan[5]);
				break;
			case 2:
				System.out.println(zamayer[5] + KlmtRaftan[rndKlmt] + AfaalRaftan[5]);
				break;
			case 3:
				System.out.println(zamayer[5] + KlmtKharidn[rndKlmt] + AfaalKharidn[5]);
				break;
			case 4:
				System.out.println(zamayer[5] + KlmtDidn[rndKlmt] + AfaalDidn[5]);
				break;
			}

	}

}
}
