package ohtu.verkkokauppa;

import ohtu.interfaces.ViitegeneraattoriInterface;
import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements ViitegeneraattoriInterface {
    
    private int seuraava;

    public Viitegeneraattori() {
        this.seuraava = 0;
    }
    
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
