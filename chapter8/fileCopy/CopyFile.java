import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public static void main(String args[]) {
		String myPath = "hehe.txt";
		String wakaka = "wakaka.txt";
		copy(myPath, wakaka);

	}

	private static boolean copy(String fileFrom, String fileTo) {
		try {
			FileInputStream in = new FileInputStream(fileFrom);
			FileOutputStream out = new FileOutputStream(fileTo);
			byte[] bt = new byte[1024];
			int count;

			while ((count = in.read(bt)) > 0) {
				out.write(bt, 0, count);
			}
			in.close();
			out.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}
}