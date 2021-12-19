package com.damian.discountcalculator.service;

import com.damian.discountcalculator.builder.DataOfProductsBuilder;
import com.damian.discountcalculator.entity.Result;
import com.damian.discountcalculator.exception.BusinessException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class with tests for result service. It tests also product service
 * because result service uses product service.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
@Suite
@SuiteDisplayName("Result Service Test")
public class ResultServiceTest {

    ResultService resultService = new ResultService();

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldReturnDiscountValue_ForRunService_WhenMapLength1(double discount) {
        //given
        //when
        List<Result> results = resultService.
                runService(DataOfProductsBuilder.buildMap(1), discount);
        //then
        assertEquals(discount, results.get(0).getDiscount());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldReturn33PercentDiscountValueFor0Element_ForRunService_WhenMapLength2(double discount) {
        //given
        //when
        List<Result> results = resultService.
                runService(DataOfProductsBuilder.buildMap(2), discount);
        String discountString = String.valueOf(discount / 3).substring(0, 3);
        String resultString = String.valueOf(results.get(0).getDiscount()).substring(0, 3);
        //then
        assertEquals(discountString, resultString);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldReturn33PercentDiscountValueFor1Element_ForRunService_WhenMapLength2(double discount) {
        //given
        //when
        List<Result> results = resultService.
                runService(DataOfProductsBuilder.buildMap(2), discount);
        String discountString = String.valueOf(discount * 2 / 3).substring(0, 3);
        String resultString = String.valueOf(results.get(1).getDiscount()).substring(0, 3);
        //then
        assertEquals(discountString, resultString);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldReturn16PercentDiscountValueFor0Element_ForRunService_WhenMapLength3(double discount) {
        //given
        //when
        List<Result> results = resultService.
                runService(DataOfProductsBuilder.buildMap(3), discount);
        String discountString = String.valueOf(discount / 6).substring(0, 3);
        String resultString = String.valueOf(results.get(0).getDiscount()).substring(0, 3);
        //then
        assertEquals(discountString, resultString);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldReturn33PercentDiscountValueFor1Element_ForRunService_WhenMapLength3(double discount) {
        //given
        //when
        List<Result> results = resultService.
                runService(DataOfProductsBuilder.buildMap(3), discount);
        String discountString = String.valueOf(discount / 3).substring(0, 3);
        String resultString = String.valueOf(results.get(1).getDiscount()).substring(0, 3);
        //then
        assertEquals(discountString, resultString);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldReturn50PercentDiscountValueFor2Element_ForRunService_WhenMapLength3(double discount) {
        //given
        //when
        List<Result> results = resultService.
                runService(DataOfProductsBuilder.buildMap(3), discount);
        //then
        assertEquals(discount / 2, results.get(2).getDiscount());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldThrowsException_ForRunService_WhenMapLength0(double discount) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> resultService.
                runService(DataOfProductsBuilder.buildMap(0), discount));
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10, 20, 30, 40 })
    public void shouldThrowsException_ForRunService_WhenMapLengthMinus1(double discount) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> resultService.
                runService(DataOfProductsBuilder.buildMap(-1), discount));
    }

    @ParameterizedTest
    @ValueSource(doubles = { 1000, 2000, 3000, 40000 })
    public void shouldThrowsException_ForRunService_WhenDiscountIsBiggerThanProductsPrice(double discount) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> resultService.
                runService(DataOfProductsBuilder.buildMap(4), discount));
    }

}
