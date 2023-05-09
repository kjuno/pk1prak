import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium implements Comparable<Medium>{
	private static int count = 0;
	private int id;
	private String titel;
	private int jahr;
	
	public Medium(String titel, int jahr) {
		this.titel = titel;
		this.jahr = jahr;
		id = count++;
	}
	
	public int alter() {
		return LocalDate.now().getYear() - jahr;
	}
	
	public abstract void druckeDaten(OutputStream stream);

	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public String getTitel() {
		return titel;
	}

	public int getJahr() {
		return jahr;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Medium m = (Medium) o;
		if(m.titel.equals(titel) && m.jahr == jahr)
			return true;
			
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titel,jahr);
	}
	
	@Override
	public int compareTo(Medium o) {
		return Integer.compare(getJahr(), o.getJahr());
	}
	
}
