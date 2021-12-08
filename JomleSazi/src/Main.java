import java.util.Random;

public class Main {

	public static void main(String[] args) {

		System.out.println(fncJomleSaz());
	}

	static private String fncJomleSaz() {
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
		Random generator = new Random();
		int rndZamir = generator.nextInt(6);
		int rndFel = generator.nextInt(4) + 1;
		int rndKlmt = generator.nextInt(5);

		switch (rndFel) {
		case 1:
			return (zamayer[rndZamir] + KlmtKhordan[rndKlmt] + AfaalKhordan[rndZamir]);
		case 2:
			return(zamayer[rndZamir] + KlmtRaftan[rndKlmt] + AfaalRaftan[rndZamir]);
		case 3:
			return(zamayer[rndZamir] + KlmtKharidn[rndKlmt] + AfaalKharidn[rndZamir]);
		case 4:
			return(zamayer[rndZamir] + KlmtDidn[rndKlmt] + AfaalDidn[rndZamir]);
		}
		return "";
	}
}
