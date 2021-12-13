import java.util.Random;

public class Main {

	public static void main(String[] args) {

		System.out.println(fncJomleSaz());
	}

	static private String fncJomleSaz() {
		String[] Zamir = { "Man ", "To ", "Oo ", "Ma ", "Shoma ", "Anha " };
		String[] Asami = { "Amir ", "Mehrdad ", "Hosein ", "Hasan ", "Moshen ", "Ali ", "Armin ", "Mohammad ", "Milad ",
				"Reza ", "Man ", "To ", "Oo ", "Ma ", "Shoma ", "Anha " };
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
		int rndAsami = generator.nextInt(16);
		if (rndAsami - 10 == rndZamir) {
			rndAsami = generator.nextInt(16);
		}
		String Jomle = Zamir[rndZamir] + "Ba " + Asami[rndAsami];

		if (rndTedad == 1) {
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
		}

		for (int i = 1; i < rndTedad; i++) {
			while (Jomle.contains(Asami[rndAsami])) {
				rndAsami = generator.nextInt(12);
			}
			Jomle += "Va " + Asami[rndAsami];
		}
		if (rndZamir <= 2) {
			rndZamir += 3;
		}
		switch (rndFel) {
		case 1:
			return (Jomle + KlmtKhordan[rndKlmt] + AfaalKhordan[rndZamir]);
		case 2:
			return (Jomle + KlmtRaftan[rndKlmt] + AfaalRaftan[rndZamir]);
		case 3:
			return (Jomle + KlmtKharidn[rndKlmt] + AfaalKharidn[rndZamir]);
		case 4:
			return (Jomle + KlmtDidn[rndKlmt] + AfaalDidn[rndZamir]);
		}

		return "";
	}
}
