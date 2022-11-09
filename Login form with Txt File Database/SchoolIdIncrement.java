import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SchoolIdIncrement {
	
	SchoolIdIncrement(){
	
		
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
		
	
	}
}


