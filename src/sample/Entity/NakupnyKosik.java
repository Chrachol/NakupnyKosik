package sample.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class NakupnyKosik implements Serializable {
    private String nazovKos;

    private List<PolozkaVKosiku> polozkyVKosiku;

    public NakupnyKosik(String nazovKos, List<PolozkaVKosiku> polozkyVKosiku) {
        this.nazovKos = nazovKos;
        this.polozkyVKosiku = polozkyVKosiku;
    }

    public String getNazovKos() {
        return nazovKos;
    }

    public void setNazovKos(String nazovKos) {
        this.nazovKos = nazovKos;
    }

    public List<PolozkaVKosiku> getPolozkyVKosiku() {
        return polozkyVKosiku;
    }

    public void setPolozkyVKosiku(List<PolozkaVKosiku> polozkyVKosiku) {
        this.polozkyVKosiku = polozkyVKosiku;
    }
}
