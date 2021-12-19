package com.damian.discountcalculator.validator;

import com.damian.discountcalculator.exception.BusinessException;
import com.damian.discountcalculator.builder.DataOfProductsBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class with tests for validators.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
@Suite
@SuiteDisplayName("Input Validator Test")
public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "3", "4", "5" })
    public void shouldReturnTrue_ForIsNumberValid_WhenNumberIsValid(String number) {
        //given
        //when
        boolean result = InputValidator.isNumberValid(number);
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " ", "0", "-1", "11", "3,5", "3.5", "Hello!" })
    public void shouldThrowsException_ForIsNumberValid_WhenNumberIsInvalid(String number) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isNumberValid(number));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Table", "table", "Small table", "S" })
    public void shouldReturnTrue_ForIsNameValid_WhenNameIsValid(String name) {
        //given
        //when
        boolean result = InputValidator.isNameValid(name);
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = { " Small table", "Small table2", "Small  table", "5", " ", "" })
    public void shouldThrowsException_ForIsNameValid_WhenNameIsInvalid(String name) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isNameValid(name));
    }

    @ParameterizedTest
    @ValueSource(strings = { "0", "1", "100000", "100,", "100.", "100.0", "10000,01", "0.2", ".2", ",2" })
    public void shouldReturnTrue_ForIsAmountValida_WhenAmountIsValid(String price) {
        //given
        //when
        boolean result = InputValidator.isAmountValid(price);
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "Table", "5d", "5 500", "" })
    public void shouldThrowsException_ForIsAmountValid_WhenAmountIsInvalid(String price) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isAmountValid(price));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 20 })
    public void shouldReturnTrue_ForIsMapValid_WhenLengthIsValid(int size) {
        //given
        Map<String, String> dataOfProducts = DataOfProductsBuilder.buildMap(size);
        //when
        boolean result = InputValidator.isMapValid(dataOfProducts);
        //then
        assertTrue(result);
    }

    @Test
    public void shouldThrowsException_ForIsMapValid_WhenLengthIsInvalid() {
        //given
        Map<String, String> dataOfProducts = new LinkedHashMap<>();
        //when
        //then
        assertThrows(BusinessException.class, () -> InputValidator.isMapValid(dataOfProducts));
    }

}
