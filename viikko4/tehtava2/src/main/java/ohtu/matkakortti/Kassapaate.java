package ohtu.matkakortti;

public class Kassapaate {
    private int myytyjaLounaita;
    public static final int HINTA = 5;

    public Kassapaate() {
        this.myytyjaLounaita = 0;
    }

    public void lataa(Maksukortti kortti, int summa) {
        kortti.lataa(summa);
    }

    public void ostaLounas(Maksukortti kortti) {
        if (HINTA <= kortti.getSaldo()) {
            kortti.osta(HINTA);
            myytyjaLounaita++;
        }
    }

    public int getMyytyjaLounaita() {
        return myytyjaLounaita;
    }
}
