package it.polito.tdp.model;

import java.time.LocalDate;

public class TestEsame {
	//ho creato un'altra classe così posso testare solo i metodi public, non i private!!

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Esame tdp = new Esame("03FYZ", "Tecniche di programmazione", "Fulvio Corno");
		System.out.println(tdp);
		Esame ami = new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno");
		System.out.println(ami);
		
		System.out.println(ami.equals(tdp));
		
		tdp.supera(30, LocalDate.now());
		System.out.println(tdp);
		tdp.supera(18, LocalDate.now());
		System.out.println(tdp);   // viene stampata l'eccezione perché ho già salvato l'esame superato

	}

}
