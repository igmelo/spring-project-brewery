package igor.springframework.projectbrewery.web.controller.v2;

import igor.springframework.projectbrewery.web.model.v2.BeerDTOv2;
import igor.springframework.projectbrewery.web.services.v2.BeerServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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

@Slf4j
@RequiredArgsConstructor //lombok will create a constructor for us
@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    @GetMapping("/{beerId}") //GET method
    public ResponseEntity<BeerDTOv2> getBeer(@NotNull @PathVariable UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping //POST method
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDTOv2 beerDTO){

        log.debug("in handle post...");

        val savedDTO = beerServiceV2.saveNewBeer(beerDTO);//LOMBOK will compile this object for us

        val headers = new HttpHeaders();//same here lombok
        headers.add("Location","/api/v1/beer/" + savedDTO.getId().toString());
        //todo add hostname to url
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")//UPDATE method
    public ResponseEntity handleUpdate(@PathVariable UUID beerId,@Valid @RequestBody BeerDTOv2 beerDTOv2){
        beerServiceV2.updateBeer(beerId, beerDTOv2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")//DELETE method
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerServiceV2.deleteById(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)//Exception handler method
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
                errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
