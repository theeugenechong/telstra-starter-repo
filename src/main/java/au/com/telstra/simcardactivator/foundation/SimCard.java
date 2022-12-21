package au.com.telstra.simcardactivator.foundation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimCard {

    @JsonProperty
    private String iccid;
    private String customerEmail;
    private boolean isActive;

    public SimCard(String iccid, String customerEmail, boolean isActive) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.isActive = isActive;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
