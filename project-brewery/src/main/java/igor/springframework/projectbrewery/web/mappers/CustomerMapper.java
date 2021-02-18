package igor.springframework.projectbrewery.web.mappers;

import igor.springframework.projectbrewery.web.controller.domain.Customer;
import igor.springframework.projectbrewery.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO beerToBeerDTO(Customer customer);

    Customer beerDTOToBeer(CustomerDTO customerDTO);
}
