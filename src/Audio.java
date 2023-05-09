import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Audio extends Medium{
	private int dauer;
	private String interpret;
	public Audio(String titel, int jahr, int dauer, String interpret) {
		super(titel, jahr);
		this.dauer = dauer;
		this.interpret = interpret;
	}
	@Override
	public void druckeDaten(OutputStream stream) {
		PrintWriter writer = new PrintWriter(stream);
		writer.printf("ID = %d \"%s\" von %s aus %d Spieldauer: %d sek.\n", getId(), getTitel(), interpret, getJahr(), dauer);
		writer.flush();
	}
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o))
			return false;
		Audio a = (Audio)o;
		if(this.dauer == a.dauer && this.interpret.equals(a.interpret))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(dauer,interpret);
	}
	
}
