package base;

public class TextNote extends Note {
	
	private String content;
	
	TextNote() {
	}
	
	public TextNote (String textnote){
		super(textnote);
		
		this.content = textnote;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent (String textnote){
		this.content = textnote;
	}
}
