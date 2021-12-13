import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		System.out.println(fncJomleSaz());
	}

	static private String fncJomleSaz() {
		String[] Zamir = { "Man ", "To ", "Oo ", "Ma ", "Shoma ", "Anha " };
		String[] Asami = { "Amir ", "Ali ", "Armin ", "Mohammad ", "Milad ", "Reza " };
		// ------ Afaal ------
		String[] AfaalKhordan = { "Khordam ", "Khordi ", "Khord ", "Khordim ", "Khordid ", "Khordand " };
		String[] AfaalRaftan = { "Raftam ", "Rafti ", "Raft ", "Raftim ", "Raftid ", "Raftand " };
		String[] AfaalKharidn = { "Kharidm ", "Kharidi ", "Kharid ", "Kharidim ", "Kharidid ", "Kharidand " };
		String[] AfaalDidn = { "Didm ", "Didi ", "Did ", "Didim ", "Didid ", "Didand " };
		// ------ Kalamat ------
		String[] KlmtKhordan = { "Qaza ", "Sham ", "Nahar ", "Kabab ", "Pitza ", "Sobhane ", "Abmive " };
		String[] KlmtRaftan = { "Be Park ", "Be Madrese ", "Be SareKar ", "Be Bashgah ", "Be Daneshgah ", "Kelas ",
				"Kharid " };
		String[] KlmtKharidn = { "Lebas ", "Ketab ", "Kafsh ", "Shalvar ", "Kapshan ", "Khoraki ", "Pirahan " };
		String[] KlmtDidn = { "Film ", "Serial ", "Mostanad ", "Cartoon ", "Video Amozeshi ", "Akhbar ", "Video " };
		// ------
		Random generator = new Random();
		int rndZamir = generator.nextInt(6);
		int rndFel = generator.nextInt(4) + 1;
		int rndKlmt = generator.nextInt(7);
		int rndTedad = generator.nextInt(3) + 1;
		int rndAsami = generator.nextInt(6);
		int rndAsami2 = generator.nextInt(6);
		
		while(rndAsami == rndAsami2) {
			rndAsami = generator.nextInt(6);
			rndAsami2 = generator.nextInt(6);
		}

		switch (rndTedad) {
		case 1:
			switch (rndFel) {
			case 1:
				return (Zamir[rndZamir] + KlmtKhordan[rndKlmt] + AfaalKhordan[rndZamir]);
			case 2:
				return (Zamir[rndZamir] + KlmtRaftan[rndKlmt] + AfaalRaftan[rndZamir]);
			case 3:
				return (Zamir[rndZamir] + KlmtKharidn[rndKlmt] + AfaalKharidn[rndZamir]);
			case 4:
				return (Zamir[rndZamir] + KlmtDidn[rndKlmt] + AfaalDidn[rndZamir]);
			}
		case 2:
			switch (rndFel) {
			case 1:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + KlmtKhordan[rndKlmt] + AfaalKhordan[rndZamir]);
			case 2:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + KlmtRaftan[rndKlmt] + AfaalRaftan[rndZamir]);
			case 3:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + KlmtKharidn[rndKlmt] + AfaalKharidn[rndZamir]);
			case 4:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + KlmtDidn[rndKlmt] + AfaalDidn[rndZamir]);
			}
		case 3:
			switch (rndFel) {
			case 1:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + "Va " + Asami[rndAsami2] + KlmtKhordan[rndKlmt]
						+ AfaalKhordan[rndZamir]);
			case 2:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + "Va " + Asami[rndAsami2] + KlmtRaftan[rndKlmt]
						+ AfaalRaftan[rndZamir]);
			case 3:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + "Va " + Asami[rndAsami2] + KlmtKharidn[rndKlmt]
						+ AfaalKharidn[rndZamir]);
			case 4:
				return (Zamir[rndZamir] + "Ba " + Asami[rndAsami] + "Va " + Asami[rndAsami2] + KlmtDidn[rndKlmt]
						+ AfaalDidn[rndZamir]);
			}
		}

		return "";
	}
}
