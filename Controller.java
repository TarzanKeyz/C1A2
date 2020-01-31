package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Controller {
    public TextArea txaListeEntiers;
    public RadioButton radCroissant;
    public RadioButton radDecroissant;
    public TextField txfMaximum;
    public TextField txfMinimum;
    public TextField txfMoyenne;
    public Label labMessage;
    public CheckBox chbConfirmation;
    public ComboBox cmb;
    public TextField txfValeur;

    public void initialize(){
        cmb.getItems().addAll("Vider", "Garnir", "Nombre 1 à 100", "Nombre -25 à 25");
    }

    /**
     * Action du comboBox
     * @param actionEvent
     */
    public void cmbActionEvent(ActionEvent actionEvent) {
        String selection = cmb.getValue().toString();

        if(selection.equals("Vider"))
            txaListeEntiers.clear();

        else if (selection.equals("Garnir"))
            txaListeEntiers.setText(ListeEntiers.garnir);
        else if(selection.equals("Nombre 1 à 100")) {
            String texte = "1\n";
            for (int i = 2; i <= 100; i++) {
                texte = texte + String.valueOf(i) + "\n";
            }
            txaListeEntiers.setText(texte);
        }
        else if (selection.equals("Nombre -25 à 25")){
            String texte = "-25\n";
            for (int i = -24; i <= 25; i++) {
                texte = texte + String.valueOf(i) + "\n";
            }
            txaListeEntiers.setText(texte);
        }
    }

    /**
     * Différent type de tri
     * @param actionEvent
     */
    public void btnTrierActionEvent(ActionEvent actionEvent) {
        String [] tab = txaListeEntiers.getText().split("\n");
        if (radCroissant.isSelected()){
            Tableaux.trierCroissantSSS(tab);
        }
        else if (radDecroissant.isSelected()){
            Tableaux.trierDecroissantSSS(tab);
        }
        txaListeEntiers.clear();
        for (String elem : tab){
            txaListeEntiers.appendText(elem + "\n");
        }
    }

    /**
     * Remplit les texfield max, min et moyenne
     * @param actionEvent
     */
    public void btnTrouverActionEvent(ActionEvent actionEvent) {
        String [] tab = txaListeEntiers.getText().split("\n");
        int [] tabInt = new int [tab.length];
        for (int i=0; i<tab.length; i++){
            tabInt[i] = Integer.parseInt(tab[i]);
            System.out.println(tabInt[i]);
        }
        txfMaximum.setText(String.valueOf(Tableaux.maximum(tabInt)));
        txfMinimum.setText(String.valueOf(Tableaux.minimum(tabInt)));
        txfMoyenne.setText(String.valueOf(Tableaux.moyenne(tab)));
    }

    /**
     * Quitte l'application
     * @param actionEvent
     */
    public void btnQuitterActionEvent(ActionEvent actionEvent) {
        if (chbConfirmation.isSelected()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous vraiment quitter?");
            Optional<ButtonType> resultat = alert.showAndWait();
            if (resultat.get() == ButtonType.OK){
                Platform.exit();
            }
        }
        else
            Platform.exit();
    }

    /**
     * Cherche un entier donné par l'utilisateur
     * @param actionEvent
     */
    public void btnChercherActionEvent(ActionEvent actionEvent) {
        String [] tab = txaListeEntiers.getText().split("\n");
        int [] tabInt = new int [tab.length];
        for (int i=0; i<tab.length; i++){
            tabInt[i] = Integer.parseInt(tab[i]);
        }
        String reponse = String.valueOf(Tableaux.fouilleSeq(tabInt, Integer.parseInt(txfValeur.getText())));
        labMessage.setText(reponse);
    }
}
