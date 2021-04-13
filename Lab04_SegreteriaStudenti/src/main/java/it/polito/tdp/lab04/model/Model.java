package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO cdao;
	StudenteDAO sdao; 

	
	public List<Corso> getTuttiCorsi(){
		return cdao.getTuttiICorsi();
		
	}
	
	public List<Studente> cercaIscrittiCorso(Corso corso ){
		return cdao.getStudentiIscrittiAlCorso(corso);
	}
	
	public boolean doIscrivi() {
		//TODO
		return false;
	}
	
	public List<Corso> cercaCorsi(Studente s){
		
		return sdao.getCorsi(s);
	}
	
	public List<Studente> getTuttiStudenti(){
		return sdao.getTuttiStudenti();
	}
	
	
	public boolean matricolaValida(String matricola) {
		List<Studente> studenti = new ArrayList(sdao.getTuttiStudenti());
		for(Studente s : studenti) {
			if(s.getMatricola().equals(matricola)) {
				return true;
			}
		}
		return false;
		
	}
	
	
	
	
}
