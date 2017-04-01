package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.libretto.db.EsameDAO;

public class Model {
	
	private List <Esame> esami;

	public Model() {
		super();
		this.esami=new ArrayList <Esame>();
	}
	
	/**
	 * aggiunge un nuovo esame all'elenco degli esami superati,
	 * verificando che non ci sia già
	 * 
	 * Devo inserire comunque un controllo per controllare se l'operazione sia andata o meno a buon fine.
	 * Per farlo ho 3 modi:
	 * 1- farlo in modo silenzioso: non farlo: NON CORRETTO
	 * 2- gestirlo facendomi restituire dalla funzione un boolean: true se è andato a buon fine
	 * 3- usare un'eccezione
	 * @param e
	 */
	public boolean addEsame(Esame e){
		/*if(!esami.contains(e)){
			esami.add(e);
			return true;
		}
		else
			return false;
		*/
		EsameDAO dao = new EsameDAO();
		return dao.create(e);
	}
	
	/**
	 * Ricercare se esiste un esame con il codice specificato.
	 * Se corretto, lo restituisce, altrimenti restituisce null.
	 */
	public Esame trovaEsame(String codice){
		/*int pos = esami.indexOf(new Esame(codice, null, null));
		if (pos==-1)
			return null;
		else
			return esami.get(pos);
		*/
		EsameDAO dao = new EsameDAO();
		Esame e = dao.find(codice);
		return e;
	}

}
