package com.damian.discountcalculator.builder;

import com.damian.discountcalculator.exception.BusinessException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class with tests for builder.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
@Suite
@SuiteDisplayName("Data of Products Builder Test")
public class DataOfProductsBuilderTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 30})
    public void shouldReturnSizeValue_ForBuildMap_WhenMapLengthIsValid(int size) {
        //given
        //when
        Map<String, String> results = DataOfProductsBuilder.buildMap(size);
        //then
        assertEquals(size, results.size());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -3, -4})
    public void shouldThrowsException_ForBuildMap_WhenMapLengthIsInvalid(int size) {
        //given
        //when
        //then
        assertThrows(BusinessException.class, () -> DataOfProductsBuilder.buildMap(size));
    }

}
