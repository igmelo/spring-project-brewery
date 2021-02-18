package igor.springframework.projectbrewery.web.mappers;

import igor.springframework.projectbrewery.web.controller.domain.Beer;
import igor.springframework.projectbrewery.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);

    Beer beerDTOToBeer(BeerDTO beerDTO);
}
