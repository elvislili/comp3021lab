package base;
import java.io.*;

public class ImageNote extends Note {
	
	private File image;
	
	ImageNote() {
	}
	
	public ImageNote (String imagenote){
		super(imagenote);
	}
	
	public File getImage() {
		return this.image;
	}
	
	public void setImage (File imagenote){
		this.image = imagenote;
	}
}
