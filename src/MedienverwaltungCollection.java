import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MedienverwaltungCollection {
	private List<Medium> list = new LinkedList<>();
	public void aufnehmen(Medium m) {
		list.add(m);
	}
	
	public void zeigeMedien() {			
		Collections.sort(list,new TitelSortierer());
		
		for(Medium m : list) {
			m.druckeDaten(System.out);
		}
	}
	
	public void sucheNeuesMedium() {
		if(list.isEmpty()) {
			return;
		}
		
		Iterator<Medium> it = list.iterator();
		
		Medium output = it.next();
			
		while(it.hasNext()) {
			Medium m = it.next();
			if(m.getJahr() > output.getJahr())
				output = m;
		}
		
		System.out.println(output.getJahr());
	}
	
	public double berechneErscheinungsjahr() {
		if(list.isEmpty()) {
			return 0.0;
		}
		int summe = 0;
		for(Medium m : list) {
			summe += m.getJahr();
		}
		return (double) (summe) / list.size();
	}
}
