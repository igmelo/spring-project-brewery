package igor.springframework.projectbrewery.web.controller.domain;

import igor.springframework.projectbrewery.web.model.v2.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyleEnum;
    private Long upc;

    private Timestamp createdDate;
    private Timestamp lastUpdateDate;
}
