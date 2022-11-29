package com.kairos.technicalproof.infrastructure.primary.api.price;

import com.kairos.technicalproof.application.usecases.ports.primary.FindPricePort;
import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.PriceNotFound;
import com.kairos.technicalproof.infrastructure.primary.api.exception.PriceNotFoundException;
import com.kairos.technicalproof.infrastructure.primary.api.model.price.FindPriceResponse;
import com.kairos.technicalproof.infrastructure.primary.api.price.mapper.FindPriceMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
@RequestMapping("/price")
@Tag(name = "Prices")
@RequiredArgsConstructor
public class FindPriceController {

    private final FindPricePort findPricePort;

    @GetMapping(value = "/{brandId}/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Find price",
            description = "Find price  by brand id, product id and date",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Price founded"),
                    @ApiResponse(responseCode = "404", description = "Price not founded"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    public Mono<FindPriceResponse> findPrice(
            @Parameter(name = "brandId", description = "Id of the brand", example = "1")
            @PathVariable Long brandId,
            @Parameter(name = "productId", description = "Id of the product", example = "35455")
            @PathVariable Long productId,
            @Parameter(name = "date", description = "Date of the request", example = "2020-06-14T12:00:00Z")
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant date
    ) {

        return findPricePort.findPrice(new BrandId(brandId), new ProductId(productId), date)
                            .map(price -> FindPriceMapper.mapToResponse(price))
                            .doOnError(PriceNotFound.class, error -> new PriceNotFoundException(error.getCode(), error.getMessage()));
    }
}
