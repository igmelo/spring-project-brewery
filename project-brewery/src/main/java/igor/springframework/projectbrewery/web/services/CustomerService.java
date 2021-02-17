package igor.springframework.projectbrewery.web.services;

import igor.springframework.projectbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);
}
