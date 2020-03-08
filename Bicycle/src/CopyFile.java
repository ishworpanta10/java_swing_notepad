import java.io.*;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		File outfile = new File("/home/ishworpanta/Documents/Java/out.txt");
		File file = new File("/home/ishworpanta/Documents/Java/source.txt");
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(outfile);
			
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		}finally {
			
			if(in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
