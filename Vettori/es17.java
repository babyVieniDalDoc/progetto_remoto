package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class es17 extends Application {
	TextField tNumeri = new TextField();
	TextField tK = new TextField();
	Label lRis = new Label("risultato");
	int vettore[];

	
	public void start(Stage finestra) {
		Button pCalcola = new Button("calcola");
		Label lVett = new Label("numeri separati da ',' ");
		Label lK = new Label("K");
		GridPane griglia = new GridPane();
		griglia.add(tNumeri, 0, 0);
		griglia.add(lVett, 1, 0);
		griglia.add(tK, 0, 1);
		griglia.add(lK, 1, 1);
		griglia.add(pCalcola, 0, 2);
		griglia.add(lRis, 0, 4);
		griglia.setPadding(new Insets(20));
		griglia.setHgap(20);
		griglia.setVgap(20);
		Scene scena = new Scene(griglia, 500, 300);
		finestra.setScene(scena);
		finestra.setTitle("numeri maggiori di K");
		finestra.show();
		pCalcola.setOnAction(e -> calcola());

	}
	private void calcola() {
		String s[], testo;
		Boolean fine = false;
		int k = Integer.parseInt(tK.getText());
		testo = tNumeri.getText();
		s = testo.split(",");
		vettore = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			vettore[i] = Integer.parseInt(s[i]);
		}
		for (int i = 0; i < vettore.length && !fine; i++) {
			if (vettore[i] <k) {
				fine = true;
			}
			
		}
		if (fine == true) {
			lRis.setText("contiene almeno un valore minore di " + k);
		} else {
			lRis.setText("non contiene almeno un valore minore di " + k);

		}

	}
	public static void main(String[] args) {
		launch(args);
	}

}