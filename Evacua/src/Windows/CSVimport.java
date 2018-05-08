package Windows;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;



public class CSVimport {
	
	public static List<String[]> readCSV (String fileName){
		String path = "C:/Users/valle/Desktop/csv/";
		Path pathToFile = Paths.get(path+fileName+".csv");
		List<String[]> imp = new ArrayList<>();
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII) ){
			String line = br.readLine();
			line = br.readLine();
			while(line != null) {
				String[] attributes = line.split(";");
				imp.add(attributes);
				line=br.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return imp;
	}
	
}
