package com.damian.discountcalculator.builder;

import com.damian.discountcalculator.exception.BusinessException;
import com.damian.discountcalculator.validator.InputValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class with build map method for tests only.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
public class DataOfProductsBuilder {

    /**
     * It builds a map with strings values where format of the first is: "Name + [i]"
     * and second is : "100 x i". Value of the i is position of the product in map.
     * Max value of i is given number. Given number can be only positive integer.
     *
     * @param number given by user number.
     * @return map of strings with information about products.
     * @throws BusinessException when given number is invalid.
     */
    public static Map<String, String> buildMap(int number) throws BusinessException {
        Map<String, String> dataOfProducts = new LinkedHashMap<>();
        for(int i = 1; i <= number; i++) {
            dataOfProducts.put("Name" + i, String.valueOf(100 * i));
        }
        InputValidator.isMapValid(dataOfProducts);
        return dataOfProducts;
    }

}
