package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimCard {

    @JsonProperty
    private String iccid;

    public SimCard(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}
