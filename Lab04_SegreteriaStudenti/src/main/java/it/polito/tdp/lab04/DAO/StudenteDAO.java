package it.polito.tdp.lab04.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente getStudente(Integer matricola){
		Studente studente = null;
		String sql = "SELECT s.nome,s.cognome, s.CDS "
				+ "FROM studente s "
				+ "WHERE s.matricola=? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement pt =  conn.prepareStatement(sql);
			pt.setInt(1,matricola);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				 studente = new Studente( rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),  rs.getString("CDS"));
				
			}
			rs.close();
			pt.close();
			conn.close();
			
		} catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		
		if(studente==null) {
			System.out.println("Student couldn't be found");
			return null;
		}
		
		return studente;
		
	}
	
	public List<Corso> getCorsi(Studente studente){
		List<Corso> corsi = new ArrayList();
		String sql="SELECT c.codins,c.nome,c.crediti,c.pd "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins=i.codins AND i.matricola=? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,studente.getMatricola());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				Corso c = new Corso(codins,nome, numeroCrediti,periodoDidattico);
				corsi.add(c);
			}
		rs.close();
		ps.close();
		conn.close();
		
		}catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		if(corsi.isEmpty()) {
			return null;
		}
		
		return corsi;
		
	}
	
	public List<Studente> getTuttiStudenti(){
		String sql="SELECT * from studente";
		List<Studente> s = null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				int matricola = rs.getInt("matricola");
				String cds = rs.getString("CDS");
				
				Studente studente = new Studente(matricola,cognome,nome,cds);
				s.add(studente);
			
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		if(s.isEmpty()) {
			return null;
		}
		
		return s;
		
	}
	
	
	
}
