package com.example.corsista.frammentiamo.data;

/**
 * Created by corsista on 22/02/2018.
 */

public class Detail {
    private String sezione;
    private String dettaglio;


    public Detail(String sezione,String dettaglio){
        this.sezione=sezione;
        this.dettaglio=dettaglio;
    }

    public String getSezione() {
        return sezione;
    }

    public void setSezione(String sezione) {
        this.sezione = sezione;
    }

    public String getDettaglio() {
        return dettaglio;
    }

    public void setDettaglio(String dettaglio) {
        this.dettaglio = dettaglio;
    }
}
