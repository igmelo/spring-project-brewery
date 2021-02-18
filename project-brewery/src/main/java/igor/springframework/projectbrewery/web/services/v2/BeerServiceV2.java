package igor.springframework.projectbrewery.web.services.v2;


import igor.springframework.projectbrewery.web.model.v2.BeerDTOv2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDTOv2 getBeerById(UUID beerId);

    BeerDTOv2 saveNewBeer(BeerDTOv2 beerDTOv2);

    void updateBeer(UUID beerId, BeerDTOv2 beerDTOv2);

    void deleteById(UUID beerId);
}
