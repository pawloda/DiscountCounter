package com.damian.discountcalculator;

import com.damian.discountcalculator.builder.DataOfProductsBuilderTest;
import com.damian.discountcalculator.service.ResultServiceTest;
import com.damian.discountcalculator.validator.InputValidatorTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Class used to run all tests.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
@Suite
@SelectClasses({ DataOfProductsBuilderTest.class,
        ResultServiceTest.class, InputValidatorTest.class })
public class SuiteTest {
}
