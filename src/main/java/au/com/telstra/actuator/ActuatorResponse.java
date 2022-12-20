package au.com.telstra.actuator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuatorResponse {

    private boolean success;

    public ActuatorResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ActuatorResponse{" + "success='" + success + '\'' + '}';
    }
}
