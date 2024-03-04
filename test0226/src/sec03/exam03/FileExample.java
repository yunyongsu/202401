package sec03.exam03;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	public static void main(String[] args) throws Exception {
		File dir2 = new File("C:/temp/images");
		dir2.mkdirs();
		
		File dir = new File("C:/temp");
		File[] list = dir.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(File file : list) {
			System.out.print(sdf.format(new Date(file.lastModified()))+"\t");
			if(file.isDirectory()) {
				System.out.print("<DIR>\t");
			}else {
				System.out.print(file.length() + "\t");
			}
			
			System.out.println(file.getName());
		}
	}
}
