package igor.springframework.projectbrewery.web.services;

import igor.springframework.projectbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);
}
