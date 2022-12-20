package au.com.telstra.simcardactivator;

public class SimCardActivation {

    private final String iccid;
    private final String customerEmail;

    public SimCardActivation(String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
