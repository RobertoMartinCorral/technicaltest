package com.kairos.technicalproof.utils.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PriceNotFound {

    // For test purposes, as object received is of type ErrorResponse

    private String code;
    private String message;
}
