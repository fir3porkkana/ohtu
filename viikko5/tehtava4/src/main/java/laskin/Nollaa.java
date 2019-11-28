package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovelluslogiikka;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;

        this.sovelluslogiikka = sovellus;
    }

    @Override
    public void suorita() {
        sovelluslogiikka.nollaa();
        tuloskentta.setText(sovelluslogiikka.tulos() + "");
    }

    @Override
    public void peru() {
        tuloskentta.setText(syotekentta.getText());
        syotekentta.setText(null);
        undo.disableProperty().set(true);
    }
}