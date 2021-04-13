package it.polito.tdp.lab04.model;

import java.util.List;

public class Studente {

	private String nome;
	private String cognome;
	private Integer matricola;
	private String CDS;
	private List<Corso> corsi;
	
	
	public Studente (int matricola, String cognome, String nome, String CDS) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.CDS = CDS;
	}
	
	
	public List<Corso> getCorsi() {
		return this.corsi;
	}



	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return this.matricola+" "+this.nome+" "+this.cognome+" "+this.CDS;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Integer getMatricola() {
		return matricola;
	}


	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}


	public String getCDS() {
		return CDS;
	}


	public void setCDS(String cDS) {
		CDS = cDS;
	}
	
	
}
