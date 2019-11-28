package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovelluslogiikka;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovelluslogiikka = sovellus;
    }

    @Override
    public void suorita() {
        sovelluslogiikka.plus(Integer.parseInt(syotekentta.getText()));
        nollaa.disableProperty().set(false);
        tuloskentta.setText(sovelluslogiikka.tulos() + "");

        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        int syote = Integer.parseInt(syotekentta.getText());
        sovelluslogiikka.miinus(syote);
        tuloskentta.setText(sovelluslogiikka.tulos() + "");
        syotekentta.setText(null);
        undo.disableProperty().set(true);
    }
}