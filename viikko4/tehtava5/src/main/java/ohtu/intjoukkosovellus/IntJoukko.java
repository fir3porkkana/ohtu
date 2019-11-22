
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5; // luotava uusi taulukko on
    // näin paljon isompi kuin vanha
    private int kasvatuskoko; // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono; // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm = 0; // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        } else if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % ljono.length == 0) {
                expand();
            }
            return true;
        }
        return false;
    }

    public void expand() {
        int[] taulukkoOld = new int[ljono.length];
        taulukkoOld = ljono;
        kopioiTaulukko(ljono, taulukkoOld);
        ljono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, ljono);
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int indexToRemove = index(luku);
        if (indexToRemove != -1) {
            fixDentLeftFromDeletion(indexToRemove);
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    private void fixDentLeftFromDeletion(int index) {
        int temp = 0;
        for (int j = index; j < alkioidenLkm - 1; j++) {
            temp = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = temp;
        }
        alkioidenLkm--;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    public int index(int i) {
        for (int j = 0; j < alkioidenLkm; j++) {
            if (ljono[j] == i) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String tuotos = "{" + ljono[0];
            for (int i = 1; i < alkioidenLkm; i++) {
                tuotos += ", ";
                tuotos += ljono[i];
            }
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] array = new int[alkioidenLkm];
        for (int i = 0; i < alkioidenLkm; i++) {
            array[i] = ljono[i];
        }
        return array;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i])) {
                y.lisaa(aTaulu[i]);
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
        return z;
    }
}
