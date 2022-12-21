package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.foundation.ActuatorResponse;
import au.com.telstra.simcardactivator.foundation.SimCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimCardActivationController {

    private final SimCardActuationHandler simCardActuationHandler;

    @Autowired
    public SimCardActivationController(SimCardActuationHandler simCardActuationHandler) {
        this.simCardActuationHandler = simCardActuationHandler;
    }

    @PostMapping("/activate")
    public void simCardActivation(@RequestBody SimCard simCard) {
        ActuatorResponse actuatorResponse = simCardActuationHandler.actuate(simCard);
        System.out.println(actuatorResponse.isSuccess());
    }
}
