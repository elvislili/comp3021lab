package base;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class NoteBook {
	private ArrayList<Folder> folders;
	
	public NoteBook(){
		folders = new ArrayList<Folder>();
	}
	
	public boolean createTextNote(String a, String b){
		TextNote note = new TextNote(b);
		return insertNote(a, note);
	}
	public boolean createTextNote(String foldername,String title,String content){
		TextNote note = new TextNote(title,content);
		return insertNote(foldername,note);
	}	
	
	public boolean createImageNote(String a, String b){
		ImageNote note = new ImageNote(b);
		return insertNote(a, note);
	}
	
	public boolean insertNote(String a, Note b){
		Folder f = null;
		for (Folder f1:folders){
			if(f1.getName().equals(a)){
				f = f1;
			}
		}
		
		if (f == null){
			f = new Folder(a);
			folders.add(f);
		}
		
		for (Note n : f.getNotes()){
			if(n.equals(b)){
				System.out.println("Create note " + b.getTitle() + " under folder " + a + " failed");
				return false;
			}
		}
		
		f.addNote(b);
		System.out.println("Create note " + b.getTitle() + " under folder " + a);
		return true;

	}
	public ArrayList<Folder> getFolders(){
		return folders;
	}
	
	public void sortFolders(){
		for(Folder f:folders){
			f.sortNotes();
		}
		//List<Folder> folders = new ArrayList<Folder>();
		Collections.sort(this.folders);
	
	}
	
	public List<Note> searchNotes(String keywords){
		List<Note> resultnote = new ArrayList<Note>();
		for(Folder f:folders){
			resultnote.addAll(f.searchNotes(keywords));
		}
		return resultnote;
	}
	
}
