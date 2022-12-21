package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.foundation.ActuatorResponse;
import au.com.telstra.simcardactivator.foundation.SimCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SimCardActivationController {

    private final SimCardActuationHandler simCardActuationHandler;
    private final DatabaseExecutor dbExecutor;

    @Autowired
    public SimCardActivationController(SimCardActuationHandler simCardActuationHandler, DatabaseExecutor dbExecutor) {
        this.simCardActuationHandler = simCardActuationHandler;
        this.dbExecutor = dbExecutor;
    }

    @GetMapping("/sim")
    public SimCard querySimById(@RequestParam(required = false) Long simCardId) {
        SimCard simCard = dbExecutor.queryById(simCardId);
        if (simCard != null) {
            System.out.println(simCard);
        }
        return simCard;
    }

    @PostMapping("/activate")
    public void activateSim(@RequestBody SimCard simCard) {
        ActuatorResponse actuatorResponse = simCardActuationHandler.actuate(simCard);
        dbExecutor.saveSim(simCard, actuatorResponse);
        System.out.println(actuatorResponse);
    }
}
