package base;
import java.util.ArrayList;
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
	
	
}
