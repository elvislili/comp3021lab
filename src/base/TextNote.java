package base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TextNote extends Note{
	
	private static final long serialVersionUID = 1L;
	private String content;
	
	
	private String getTextFromFile(String absolutePath) {
		String result = "";
		
		try {
			
			BufferedReader in = new BufferedReader(new FileReader(absolutePath));
			
			while(in.readLine() != null){
				result = in.readLine();
			}
			
			in.close();
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		
			result = "The file doesn't exist. Please check your path.";
		}catch (IOException e){
			
			result = "Error occurrs: the file cannot be read.";
		}
		
		
		
		return result;
}
	
	public TextNote (String title, String content){
		
		super(title);
		this.content = content;
	}

	
	
	public TextNote(File f) {
		
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
		
		}
	
	
	public String getContent (){
		
		return content;
	}
	
	public void exportTextToFile(String pathFolder) {
		
		String fileName = this.getTitle().replaceAll(" ", "_");
		
		//TODO
		//File file = new File( pathFolder + File.separator + fileName + ".txt");
		File file = new File(fileName + ".txt");
		
		
		FileWriter fw;
		
		try {
			
			fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(this.content);
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("The file cannot be exported.");
			//System.err.println("Caught IOException: " +  e.getMessage());
		
            
		}
		

		// TODO
		}

}