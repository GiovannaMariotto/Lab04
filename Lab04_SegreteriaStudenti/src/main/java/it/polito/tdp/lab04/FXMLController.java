/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class FXMLController {
	
    @FXML
    private ChoiceBox<String> choicebox;
    
  
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btncercaiscritti;

    @FXML
    private CheckBox checkEsiste;

    @FXML
    private TextField nomeStudente;

    @FXML
    private Button btncercacorsi;
    
    @FXML
    private TextField txtmatricola;

    @FXML
    private Button btniscrivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;
   
    List<Corso> corsi = this.model.getTuttiCorsi();
    List<Studente> studenti = this.model.getTuttiStudenti();
    public void setChoiceBox(ChoiceBox choicebox) {
    	corsi =  new ArrayList(this.model.getTuttiCorsi());
        ObservableList<String> choices=null;
        choices.add(" ");
        for(Corso c : corsi) {
        	choices.add(c.getNomeCorso());
        }
        choicebox.setItems(choices);

    }

    @FXML
    void cercaCorsi(ActionEvent event) {
    	String matricolaString = this.txtmatricola.getText();
    	Integer matricola;
    		
    	try {
    		matricola = Integer.parseInt(matricolaString);
    	}catch(NumberFormatException nfe) {
    		this.txtRisultato.setText("NumberFormatException!");
    		throw new RuntimeException(nfe);
    	}catch(NullPointerException npe) {
    		this.txtRisultato.setText("NullPointerException!");
    		throw new RuntimeException(npe);
    	}
    	Studente studente1 = null;
    	for(Studente s : studenti) {
    		if(matricola==s.getMatricola()) {
    			studente1 = s;
    			break;
    		}
    	}
    	if(studente1==null) {
    		this.txtRisultato.setText("Studente non trovato");
    		return;
    	}
    	
    	List<Corso> iscrittineicorsi = this.model.cercaCorsi(studente1);
    	this.txtRisultato.setText(iscrittineicorsi.toString());
    }

    @FXML
    void cercaIscrittiCorso(ActionEvent event) {
    	
    	String s = choicebox.getValue().toString();
    	Corso c = new Corso(s,null,null,null);
    	for(Corso corso : corsi) {
    		if(corso.getCodins().equals(c.getCodins())) {
    			c.setCrediti(corso.getCrediti());
    			c.setNomeCorso(corso.getNomeCorso());
    			c.setPd(corso.getPd());
    		}
    	}

    	List<Studente> studenteIscritti = new ArrayList(this.model.cercaIscrittiCorso(c));
    	this.txtRisultato.setText(studenteIscritti.toString());
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	
    	
    }

    @FXML
    void initialize() {
    	   assert txtmatricola != null : "fx:id=\"txtmatricola\" was not injected: check your FXML file 'Scene.fxml'.";
    	assert choicebox != null : "fx:id=\"choicebox\" was not injected: check your FXML file 'Scene.fxml'.";
    	assert btncercaiscritti != null : "fx:id=\"btncercaiscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert checkEsiste != null : "fx:id=\"checkEsiste\" was not injected: check your FXML file 'Scene.fxml'.";
        assert nomeStudente != null : "fx:id=\"nomeStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btncercacorsi != null : "fx:id=\"btncercacorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btniscrivi != null : "fx:id=\"btniscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    protected Model model;
    public void setModel( Model model) {
    	this.model=model;
    }
    
}