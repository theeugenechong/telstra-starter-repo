package au.com.telstra.simcardactivator.model;

import au.com.telstra.simcardactivator.foundation.ActuatorResponse;
import au.com.telstra.simcardactivator.foundation.SimCard;

import javax.persistence.*;

@Entity
public class SimCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String iccid;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private boolean isActive;

    protected SimCardModel() {
    }

    public SimCardModel(SimCard simCard, ActuatorResponse response) {
        this.iccid = simCard.getIccid();
        this.customerEmail = simCard.getCustomerEmail();
        this.isActive = response.isSuccess();
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
