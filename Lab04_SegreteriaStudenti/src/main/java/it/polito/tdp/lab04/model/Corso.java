package it.polito.tdp.lab04.model;

public class Corso { //Java Bean

	private String codins;
	private String nomeCorso;
	private Integer crediti;
	private Integer pd; //Periodo Diddatico = 1,2
	
	public Corso(String codins, String nomeCorso, Integer crediti, Integer pd) {
		super();
		this.codins = codins;
		this.nomeCorso = nomeCorso;
		this.crediti = crediti;
		this.pd = pd;
	}

	@Override
	public String toString() {
		return codins +" "+ nomeCorso + " "+ crediti + " "+ pd+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}

	public String getCodins() {
		return codins;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public Integer getCrediti() {
		return crediti;
	}

	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}

	public Integer getPd() {
		return pd;
	}

	public void setPd(Integer pd) {
		this.pd = pd;
	}
	
	
}
