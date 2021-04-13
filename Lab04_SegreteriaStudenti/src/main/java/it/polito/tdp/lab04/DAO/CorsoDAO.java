package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
		 */
	/**
	 * Get tutti i corsi salvati nel DB
	 * @return lista di Corsi
	 */

	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				
				Corso c = new Corso(codins,nome,numeroCrediti,periodoDidattico);
				corsi.add(c);
				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/**
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		List<Corso> corsi = this.getTuttiICorsi();
		for(Corso c : corsi) {
			if(c.getCodins().equals(corso.getCodins())) {
				corso.setNomeCorso(c.getNomeCorso());
				corso.setCrediti(c.getCrediti());
				corso.setPd(c.getPd());
			}
		}
		
	}
			
			
		
	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	
	/**
	 * Prende tutte le studenti iscritti al corso
	 * 
	 * @param corso
	 * @return lista di Studenti oppure null
	 */
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		List<Studente> studenti=new ArrayList<Studente>();
		String sql="SELECT s.matricola, s.nome, s.cognome, s.cds "
				+ "FROM iscrizione i, corso c, studente s "
				+ "WHERE i.matricola=s.matricola AND c.codins=i.codins AND c.codins=? ";
				

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");
				
				Studente s = new Studente(matricola,cognome,nome,cds);
				studenti.add(s);
			} }catch(SQLException sqle) {
				throw new RuntimeException(sqle);
			}
		if(studenti.isEmpty()) {
			return null;
		}
		
			return studenti;
	}

	/**
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 * @return ritorna true se l'iscrizione e' avvenuta con successo
	 **/
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
