package sample.Entity;

import java.io.Serializable;

public class PolozkaVKosiku implements Serializable {
    private String nazovPol;
    private int pocet;
    private boolean kupene;

    public PolozkaVKosiku(String nazovPol, int pocet) {
        this.nazovPol = nazovPol;
        this.pocet = pocet;
        this.kupene = false;
    }

    public String getNazovPol() {
        return nazovPol;
    }

    public void setNazovPol(String nazovPol) {
        this.nazovPol = nazovPol;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    public boolean isKupene() {
        return kupene;
    }

    public void setKupene(boolean kupene) {
        this.kupene = kupene;
    }
}
