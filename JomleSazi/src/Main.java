import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		System.out.println(fncJomleSaz());
	}

	static private String fncJomleSaz() {
		List<String[]> Zamayer = new ArrayList<String[]>();
		String[] ZamirMan = { "Man ", "Man Ba to ", "Man Ba Amir ", "Man Ba Amir va Ali ", "Man ba Shoma ",
				"Man ba Anha ", "Man Ba to va Amir " };
		String[] ZamirTo = { "To ", "To Ba Man ", "To Ba Amir ", "To Ba Amir va Ali ", "To ba Anha ", "To ba ma ",
				"To Ba Man va Amir " };
		String[] ZamirOo = { "Amir ", "Ali Ba Man ", "Oo Ba Amir ", "Reza ", "Mohammad ", "Ali Ba Milad ",
				"Mohmmad Ba Man va Amir " };
		String[] ZamirMa = { "Ma ", "Ali va Man ", "Man va mohammad va armin ", "Ma va Amir ", "Ma ba Shoma ",
				"Ma ba Amir  ", "Ma ba Mohmmad va Reza va Amir " };
		String[] ZamirShoma = { "Shoma ", "Shoma ba Amir ", "Shoma ba mohammad va Armin ", "Ma va Amir ",
				"Shoma ba Ma va Ali ", "To va Ali  ", "To ba Mohmmad va Reza va Amir " };
		String[] ZamirAnha = { "Anha ", "Ali va Amir ", "Anha ba mohammad va armin ", "Reza va Amir ",
				"Armin ba Hosein va Ali ", "Mohammad va Ali  ", "Amir va Mohmmad va Reza va Ali " };
		Zamayer.add(ZamirMan);
		Zamayer.add(ZamirTo);
		Zamayer.add(ZamirOo);
		Zamayer.add(ZamirMa);
		Zamayer.add(ZamirShoma);
		Zamayer.add(ZamirAnha);
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
		int rndzmyrzir = generator.nextInt(7);

		switch (rndFel) {
		case 1:
			return (Zamayer.get(rndZamir)[rndzmyrzir] + KlmtKhordan[rndKlmt] + AfaalKhordan[rndZamir]);
		case 2:
			return (Zamayer.get(rndZamir)[rndzmyrzir] + KlmtRaftan[rndKlmt] + AfaalRaftan[rndZamir]);
		case 3:
			return (Zamayer.get(rndZamir)[rndzmyrzir] + KlmtKharidn[rndKlmt] + AfaalKharidn[rndZamir]);
		case 4:
			return (Zamayer.get(rndZamir)[rndzmyrzir] + KlmtDidn[rndKlmt] + AfaalDidn[rndZamir]);
		}
		return "";
	}
}
