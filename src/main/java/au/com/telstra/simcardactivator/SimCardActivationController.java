package au.com.telstra.simcardactivator;

import au.com.telstra.actuator.ActuatorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SimCardActivationController {

    private static final String ACTUATOR_URL = "http://localhost:8444/actuate";
    private static final Logger log = LoggerFactory.getLogger(SimCardActivationController.class);
    private final RestTemplate restTemplate;

    @Autowired
    public SimCardActivationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/activate")
    public void simCardActivation(@RequestBody SimCardActivation activation) {
        SimCard simCard = new SimCard(activation.getIccid());
        ActuatorResponse actuatorResponse = restTemplate.postForObject(ACTUATOR_URL, simCard, ActuatorResponse.class);
        log.info(actuatorResponse.toString());
    }
}
