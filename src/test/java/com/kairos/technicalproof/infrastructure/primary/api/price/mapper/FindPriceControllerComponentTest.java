package com.kairos.technicalproof.infrastructure.primary.api.price.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kairos.technicalproof.utils.model.FindPriceResponse;
import com.kairos.technicalproof.utils.model.PriceNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindPriceControllerComponentTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At10AndPriceList1() throws Exception {
        // GIVEN (data configured in DatabaseInitialLoad)

        //WHEN
        MockHttpServletResponse response = mvc.perform(get("/price/1/35455?date=2020-06-14T10:00:00Z")
                .contentType(MediaType.APPLICATION_JSON))
                                              .andReturn().getResponse();
        FindPriceResponse receivedResponse = toPriceResponse(response.getContentAsString());

        // THEN
        assertEquals(response.getStatus(), HttpStatus.OK.value());

        assertEquals(receivedResponse.getAmount(), new BigDecimal("35.50"));
        assertEquals(receivedResponse.getBrandId(), 1L);
        assertEquals(receivedResponse.getProductId(), 35455L);
        assertEquals(receivedResponse.getPriceListId(), 1L);
        assertEquals(receivedResponse.getInitialDate(), Instant.parse("2020-06-14T00:00:00Z"));
        assertEquals(receivedResponse.getFinalDate(), Instant.parse("2020-12-31T23:59:59Z"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At16AndPriceList2() throws Exception {
        // GIVEN (data configured in DatabaseInitialLoad)

        //WHEN
        MockHttpServletResponse response = mvc.perform(get("/price/1/35455?date=2020-06-14T16:00:00Z")
                .contentType(MediaType.APPLICATION_JSON))
                                              .andReturn().getResponse();
        FindPriceResponse receivedResponse = toPriceResponse(response.getContentAsString());

        // THEN
        assertEquals(response.getStatus(), HttpStatus.OK.value());

        assertEquals(receivedResponse.getAmount(), new BigDecimal("25.45"));
        assertEquals(receivedResponse.getBrandId(), 1L);
        assertEquals(receivedResponse.getProductId(), 35455L);
        assertEquals(receivedResponse.getPriceListId(), 2L);
        assertEquals(receivedResponse.getInitialDate(), Instant.parse("2020-06-14T15:00:00Z"));
        assertEquals(receivedResponse.getFinalDate(), Instant.parse("2020-06-14T18:30:00Z"));

    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At21AndPriceList1() throws Exception {
        // GIVEN (data configured in DatabaseInitialLoad)

        //WHEN
        MockHttpServletResponse response = mvc.perform(get("/price/1/35455?date=2020-06-14T21:00:00Z")
                .contentType(MediaType.APPLICATION_JSON))
                                              .andReturn().getResponse();
        FindPriceResponse receivedResponse = toPriceResponse(response.getContentAsString());

        // THEN
        assertEquals(response.getStatus(), HttpStatus.OK.value());

        assertEquals(receivedResponse.getAmount(), new BigDecimal("35.50"));
        assertEquals(receivedResponse.getBrandId(), 1L);
        assertEquals(receivedResponse.getProductId(), 35455L);
        assertEquals(receivedResponse.getPriceListId(), 1L);
        assertEquals(receivedResponse.getInitialDate(), Instant.parse("2020-06-14T00:00:00Z"));
        assertEquals(receivedResponse.getFinalDate(), Instant.parse("2020-12-31T23:59:59Z"));

    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune15th2020At10AndPriceList3() throws Exception {
        // GIVEN (data configured in DatabaseInitialLoad)

        //WHEN
        MockHttpServletResponse response = mvc.perform(get("/price/1/35455?date=2020-06-15T10:00:00Z")
                .contentType(MediaType.APPLICATION_JSON))
                                              .andReturn().getResponse();
        FindPriceResponse receivedResponse = toPriceResponse(response.getContentAsString());

        // THEN
        assertEquals(response.getStatus(), HttpStatus.OK.value());

        assertEquals(receivedResponse.getAmount(), new BigDecimal("30.50"));
        assertEquals(receivedResponse.getBrandId(), 1L);
        assertEquals(receivedResponse.getProductId(), 35455L);
        assertEquals(receivedResponse.getPriceListId(), 3L);
        assertEquals(receivedResponse.getInitialDate(), Instant.parse("2020-06-15T00:00:00Z"));
        assertEquals(receivedResponse.getFinalDate(), Instant.parse("2020-06-15T11:00:00Z"));

    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune16th2020At21AndPriceList4() throws Exception {
        // GIVEN (data configured in DatabaseInitialLoad)

        //WHEN
        MockHttpServletResponse response = mvc.perform(get("/price/1/35455?date=2020-06-16T21:00:00Z")
                .contentType(MediaType.APPLICATION_JSON))
                                              .andReturn().getResponse();
        FindPriceResponse receivedResponse = toPriceResponse(response.getContentAsString());

        // THEN
        assertEquals(response.getStatus(), HttpStatus.OK.value());

        assertEquals(receivedResponse.getAmount(), new BigDecimal("38.95"));
        assertEquals(receivedResponse.getBrandId(), 1L);
        assertEquals(receivedResponse.getProductId(), 35455L);
        assertEquals(receivedResponse.getPriceListId(), 4L);
        assertEquals(receivedResponse.getInitialDate(), Instant.parse("2020-06-15T16:00:00Z"));
        assertEquals(receivedResponse.getFinalDate(), Instant.parse("2020-12-31T23:59:59Z"));

    }

    @Test
    public void Test6() throws Exception {
        // GIVEN (data configured in DatabaseInitialLoad)

        //WHEN
        MockHttpServletResponse response = mvc.perform(get("/price/1/35455?date=2022-01-01T21:00:00Z")
                .contentType(MediaType.APPLICATION_JSON))
                                              .andReturn().getResponse();
        PriceNotFound receivedResponse = toNotFoundResponse(response.getContentAsString());

        // THEN
        assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());

        assertEquals(receivedResponse.getCode(), "DOM-ERR0001");
        assertEquals(receivedResponse.getMessage(), "Price from brand 1 and product 35455 at 2022-01-01T21:00:00Z cannot be found");
    }

    public static FindPriceResponse toPriceResponse(String httpResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new StdDateFormat());
        try {
            return objectMapper.readValue(httpResponse, FindPriceResponse.class);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PriceNotFound toNotFoundResponse(String httpResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new StdDateFormat());
        try {
            return objectMapper.readValue(httpResponse, PriceNotFound.class);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

}
