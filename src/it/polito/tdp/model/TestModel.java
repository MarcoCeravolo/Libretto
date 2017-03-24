package it.polito.tdp.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = new Model();
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di programmazione", "Fulvio Corno")));
		//restituisce true perchè non esisteva, allora lo aggiunge e mi da true
		m.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno"));
		System.out.println(m.trovaEsame("03FYZ"));
		System.out.println(m.trovaEsame("01QZP"));
		System.out.println(m.trovaEsame("99QZP")); // non lo trova
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di programmazione", "Fulvio Corno")));
		//restituisce false perchè esisteva già, allora non lo aggiunge e mi da false
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche", "Fulvio Corno")));
		//restituisce true perchè non esisteva, allora lo aggiunge e mi da true
		//INFATTI ANCHE SE CAMBIO QUALCHE ATTRIBUTO IL CONFRONTO é FATTO SUL CODICE
		System.out.println(m.addEsame(new Esame("04FYZ", "Tecniche di programmazione", "Fulvio Corno")));
		System.out.println(m.trovaEsame("04FYZ"));
		//Basta cambiare il codice e anche se gli altri attributi sono uguali a un altro esame, 
		//quello è di fatto un nuovo esame
	}

}
