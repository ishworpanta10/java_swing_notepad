import java.io.*;

public class WriteFileExample {

	public static void main(String[] args) {
		
		FileOutputStream fop = null;
		File file;
		String content = "Hello I am ISHWOR PANTA";
		
		try {
			file  = new File("/home/ishworpanta/Documents/Java/write.txt");
			fop  = new FileOutputStream(file);
			
			//if file does not exist
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			//get the content in bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println("Done");

		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fop!=null) {
					fop.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
				
			}
		}
			
	}
}
