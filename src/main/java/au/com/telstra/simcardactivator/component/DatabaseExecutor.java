package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.foundation.ActuatorResponse;
import au.com.telstra.simcardactivator.foundation.SimCard;
import au.com.telstra.simcardactivator.model.SimCardModel;
import au.com.telstra.simcardactivator.model.SimCardModelRepository;
import org.springframework.stereotype.Component;


@Component
public class DatabaseExecutor {

    private SimCardModelRepository simCardModelRepository;

    public DatabaseExecutor(SimCardModelRepository repository) {
        this.simCardModelRepository = repository;
    }

    public void saveSim(SimCard simCard, ActuatorResponse response) {
        SimCardModel simCardModel = new SimCardModel(simCard, response);
        simCardModelRepository.save(simCardModel);
    }

    public SimCard queryById(Long simCardId) {
        if (simCardId == null) {
            return null;
        }

        var queriedSimCard = simCardModelRepository.findById(simCardId).orElse(null);
        if (queriedSimCard == null) {
            return null;
        }

        return new SimCard(queriedSimCard.getIccid(), queriedSimCard.getCustomerEmail(), queriedSimCard.isActive());
    }
}
