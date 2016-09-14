package base;
import java.util.ArrayList;
import static java.lang.System.out;

public class Folder {
	private String name;
	private ArrayList<Note> notes;
	
	Folder(){
		
	}
	
	public Folder (String a){
		this.name = a;
		this.notes = new ArrayList<Note>();
	}
	
	public void addNote (Note note){
		notes.add(note);
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Note> getNotes(){
		return notes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	public String toString() {
		int numoftext = 0;
		int numofimage = 0;
		
		for (int i=0; i<notes.size(); i++){
			Object newnote = new Note();
			newnote = notes.get(i);
			if(newnote instanceof TextNote){
				numoftext++;
			}
			else if(newnote instanceof ImageNote){
				numofimage++;
			}
		}
		
		String output = this.name + ":" + numoftext + ":" + numofimage;
		
		return output;
		
	}
}
