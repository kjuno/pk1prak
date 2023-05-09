import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Bild extends Medium{
	private String ort;
	public Bild(String titel, int jahr, String ort) {
		super(titel, jahr);
		this.ort = ort;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void druckeDaten(OutputStream stream) {
		PrintWriter writer = new PrintWriter(stream);
		writer.printf("ID = %d \"%s\" aufgenommen im Jahr %d in %s\n", getId(), getTitel(), getJahr(), ort);
		writer.flush();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o))
			return false;
		Bild a = (Bild)o;
		if(this.ort.equals(a.ort))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(ort);
	}

}
