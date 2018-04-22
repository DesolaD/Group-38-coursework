import java.io.FileInputStream;

public class Simulation {
	
	private Reader read;
	FileInputStream fis = null;
	
	public Simulation(){
		read = new Reader();
		}
	
	public String a(){
		return read.readStream();
	}
	
}
