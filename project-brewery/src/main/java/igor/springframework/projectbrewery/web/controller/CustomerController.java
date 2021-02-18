package igor.springframework.projectbrewery.web.controller;

import igor.springframework.projectbrewery.web.model.CustomerDTO;
import igor.springframework.projectbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer (@NotNull @PathVariable UUID customerId){ //GET method
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody CustomerDTO customerDTO){//POST method
        CustomerDTO savedDTO = customerService.saveNewCustomer(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/" + savedDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")//UPDATE method
    public ResponseEntity handleUpdate(@PathVariable UUID customerId, @Valid @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerId, customerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")//DELETE method
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID customerId){
        customerService.deleteCustomerById(customerId);
    }


}
