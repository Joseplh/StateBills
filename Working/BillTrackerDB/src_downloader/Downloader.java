import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Downloader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedInputStream in = new BufferedInputStream(new URL("https://nebraskalegislature.gov/bills/search_by_date.php?SessionDay=2020&print=csv").openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream("output.csv")) {
				    byte dataBuffer[] = new byte[1024];
				    int bytesRead;
				    System.out.println("Downloading...");
				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				        fileOutputStream.write(dataBuffer, 0, bytesRead);
				    }
				} catch (IOException e) {
				    // handle exception
				}
	}

}
