import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Schoolid {
	
	protected static int idno = 1001;
	
	public int id() {
		return idno;
	}
	
	public static String idnum() {
		String idnum;
		String idnum1 = null;
		
		try {
			File file = new File("Personalinfo.txt");
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				String[] info = scan.nextLine().split(":");
				
				for(int i = 0; i < info.length; i++) {
					String[] data = info[i].split(",");
					idnum = data[0] + " ";
					idnum1 = idnum;
				}
			}
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
		}
		return idnum1;
	}

}
