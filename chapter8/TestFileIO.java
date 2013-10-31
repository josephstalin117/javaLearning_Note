import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class TestFileIO {
	public static void main(String args[]) {
		if (copyFile("c:\\subdir\\edu_look.bmp", "c:\\c.bmp")) {
			System.out.println("copy file succeed.");
			;
		}

	}

	static boolean copyFile(String from, String to) {
		// File fromFile = new File("c:\\subdir\\crt.txt");
		// File toFile=new File("c:\\crtt.txt");
		File fromFile = new File(from);
		File toFile = new File(to);

		try {

			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(fromFile));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(toFile));

			int c;
			while ((c = bis.read()) != -1) {
				bos.write(c);
			}

			bis.close();
			bos.close();
			return true;

		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
}
