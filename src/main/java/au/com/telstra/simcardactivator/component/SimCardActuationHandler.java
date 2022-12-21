package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.foundation.ActuatorResponse;
import au.com.telstra.simcardactivator.foundation.SimCard;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimCardActuationHandler {

    private final RestTemplate restTemplate;
    private static final String ACTUATOR_URL = "http://localhost:8444/actuate";

    public SimCardActuationHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ActuatorResponse actuate(SimCard simCard) {
        return restTemplate.postForObject(ACTUATOR_URL, simCard, ActuatorResponse.class);
    }
}
