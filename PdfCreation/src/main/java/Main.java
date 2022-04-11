import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		PdfTools pt = new PdfTools("FinalTest", "./", "./trado.ttf", 595, 842, 50, 50);
		pt.buildFile();
		pt.addText("امير رجبي", 0, 0, "#FF0000", 20);
		pt.addText("تهران", 80, 500, "#0000FF", 15);
		pt.addText("1381", 200, 500, "#000000", 10);
		pt.addPhoto("./test.jpg", 80, 200, 100, 100);
		// pt.rotation(90);
		pt.closeFile();
	}

}