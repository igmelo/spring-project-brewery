package igor.springframework.projectbrewery.web.services;

import igor.springframework.projectbrewery.web.model.BeerDTO;
import igor.springframework.projectbrewery.web.model.v2.BeerDTOv2;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteById(UUID beerId);
}
