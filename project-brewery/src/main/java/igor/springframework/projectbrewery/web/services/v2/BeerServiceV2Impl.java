package igor.springframework.projectbrewery.web.services.v2;

import igor.springframework.projectbrewery.web.model.v2.BeerDTOv2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDTOv2 getBeerById(UUID beerId){
        return null;
    }

    @Override
    public BeerDTOv2 saveNewBeer(BeerDTOv2 beerDTO) {
        return null;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOv2 beerDTO) {
        log.debug("Updating a beer...");
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a beer...");
    }
}
