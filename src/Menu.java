import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	private MedienverwaltungCollection mv;
	private Medium neuesMedium;
	
	public Menu(){
		mv = new MedienverwaltungCollection();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Medienverwaltung\n");
		boolean beendet = false;
		while(!beendet) {
			ausgabe();
			int auswahl = sc.nextInt();
			
			if(auswahl > 6 || auswahl < 1) {
				System.out.println("Falsche Eingabe! \n");
				continue;
			}
			
			beendet = auswahl(auswahl);
		}
	}
	
	private void ausgabe() {
		System.out.println("1. Audio aufnehmen\n"
				+ "2. Bild aufnehmen\n"
				+ "3. Zeige alle Medien\n"
				+ "4. Medienliste in Datei schreiben"
				+ "5. Zeige neues Medium\n"
				+ "6. Berechne durchschnittliches Erscheinungsjahr\n"
				+ "7. Beenden\n"
				+ "Bitte Menuepunkt waehlen:");
	}
	
	private boolean auswahl(int auswahl) {
		switch(auswahl) {
		case 1: //Audio aufnehmen
			audioAufnehmen();
			break;
		case 2: //Bild aufnehmen
			bildAufnehmen();
			break;
		case 3: //Zeige alle Medien
			mv.zeigeMedien();
			break;
		case 4: //Zeige neues Medium
			if(neuesMedium != null)
				neuesMedium.druckeDaten(System.out);
			break;
		case 5: //Berechne durchschnitliches Erscheinungsjahr
			System.out.printf("Durchschnitt: %.02f",mv.berechneErscheinungsjahr());
			break;
		case 6: //Beenden
			return true;
		}
		return false;	
	}
	
	private void audioAufnehmen() {
		
		
		String text = JOptionPane.showInputDialog("Biite iwas eintippen");
		// 1. Fall : Es wird nix eingetippt und cancel gedrückt-> Nullreferenz haben
		if(text == null) return;
		int zahl;
		try {
			zahl = Integer.parseInt(text);
		} catch(NumberFormatException e) {
			
		}
		
		
		
		
		
		
		
		String titel;
		
		if((titel = JOptionPane.showInputDialog(null, "Titel eingeben (String):")) == null) {
			// Sollte JOptionPane abgebrochen werden, so soll auf Nullreferenz überprüft werden
			// Ist dies der Fall, einfach abbrechen und Funktion verlassen
			return;
		}
		
		int jahr = 0;
		try {
			jahr = zahlAbfragen("Erscheinungsjahr");
		} catch (CancelledException e1) {
			return; //siehe oben
		}
		
		int dauer = 0;
		try {
			dauer = zahlAbfragen("Dauer");
		} catch (CancelledException e) {
			return; //siehe oben
		}
		
		String interpret;
		if((interpret = JOptionPane.showInputDialog(null, "Interpret eingeben (String):")) == null) return;
		
		mv.aufnehmen(neuesMedium = new Audio(titel, jahr, dauer, interpret));
	}
	
	private void bildAufnehmen() {
		String titel;
		if((titel = JOptionPane.showInputDialog(null, "Titel eingeben (String):")) == null) 
			return; //siehe oben
		
		int jahr = 0;
		try {
			jahr = zahlAbfragen("Erscheinungsjahr");
		} catch (CancelledException e) {
			return;
		}
		
		String ort;
		if((ort = JOptionPane.showInputDialog(null, "Ort eingeben (String):")) == null) 
			return; //siehe oben
		
		mv.aufnehmen(neuesMedium = new Bild(titel, jahr, ort));
	}
	
	private int zahlAbfragen(String typ) throws CancelledException {
		int zahl = 0;
		boolean richtig = false;
		while(!richtig) {
			try{
				String sZahl;
				if((sZahl = JOptionPane.showInputDialog(null, typ + " eingeben (Zahl):")) == null)
					// Hab hier mit ner Exception gearbeitet, lässt sich streiten ob es wirklich eine "Exception" ist
					throw new CancelledException("Abfrage wurde abgebrochen!"); 
				zahl = Integer.parseInt(sZahl);
				richtig = true;
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Bitte gültige(s) " + typ + " einegeben!");
			}
		}
		return zahl;
	}
	
}
