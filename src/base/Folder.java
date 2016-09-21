package base;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Folder implements Comparable<Folder>{
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
	
	public int compareTo(Folder f){
		return this.name.compareTo(f.getName());
	}
	
	public void sortNotes(){
		//List<Note> notes = new ArrayList<Note>();
		Collections.sort(this.notes);
	}
	
	public List<Note> searchNotes (String keywords){
		String key = keywords.toLowerCase();
		String[] keys = key.split(" ");
		for(int i = 0;i < keys.length;i++)
			keys[i] = keys[i].trim();
		
		List<Note> resultnotes = new ArrayList<Note>();
		
		for(Note n:notes){
			TextNote tn = null;
			if(n instanceof TextNote){
				tn = (TextNote)n;
				int i = 0;
				while(i < keys.length){
					if(i == keys.length - 1){
						if(tn.getTitle().matches(".*"+keys[i]+".*")||tn.getContent().matches(".*"+keys[i]+".*")){
							resultnotes.add(tn);
						}
						i++;
					}
					else if((i == keys.length-3 )&&( keys[i+1].equals("or"))){
						if((tn.getTitle().matches(".*"+keys[i]+".*")||tn.getContent().matches(".*"+keys[i]+".*"))||(tn.getTitle().matches(".*"+keys[i+2]+".*")||tn.getContent().matches(".*"+keys[i+2]+".*")))
							resultnotes.add(tn);
						i++;
					}
					else if((keys[i+1].equals("or"))&&(i != keys.length-2)){
						if(!((tn.getTitle().matches(".*"+keys[i]+".*")||tn.getContent().matches(".*"+keys[i]+".*"))||(tn.getTitle().matches(".*"+keys[i+2]+".*")||tn.getContent().matches(".*"+keys[i+2]+".*")))){
							break;
						}
						else{
							i = i + 3;
							while(keys[i].equals("or")&&i<keys.length){
								i += 2;
							}
						}
					}
					else{
						if(!(tn.getTitle().matches(".*"+keys[i]+".*")||tn.getContent().matches(".*"+keys[i]+".*"))){
							break;
						}
						i++;
					}
				}
			}
			else{
				int i = 0;
				while(i < keys.length){
					if(i == keys.length-1){
						if(match(keys[i],n.getTitle())){
							resultnotes.add(n);
						}
						i++;
					}
					else if((i == keys.length - 3 )&&( keys[i+1].equals("or"))){
						if(match(keys[i],n.getTitle().toLowerCase()) || match(keys[i+2],n.getTitle().toLowerCase())){
							resultnotes.add(n);
						}
						i++;
					}
					else if((keys[i+1].equals("or"))&&(i != keys.length-2)){
						if(!(match(keys[i],n.getTitle().toLowerCase()) || match(keys[i+2],n.getTitle().toLowerCase())) ){
							break;
						}
						else{
							
							i = i + 3;
							while(keys[i].equals("or")&&i<keys.length){
								i = i + 2;
							}
						}
					}
					else{
						if(!(match(keys[i],n.getTitle() ))){
							break;
						}
						else{
							i++;
						}
					}
				}
			}
		}
		return resultnotes;	
	}
	private boolean match(String key,String a){
		if(a.matches(".*"+key+".*")||a.matches(".*"+key)||a.matches(key+".*")){
			return true;
		}
		return false;
	}
}
