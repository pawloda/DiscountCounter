package com.damian.discountcalculator.validator;

import com.damian.discountcalculator.exception.BusinessException;

import java.util.Map;
import java.util.Objects;

/**
 * Class checks if the input given by user is valid. Contains 3 methods for
 * validating given by users: product's name, product's price.
 * There is also method to validate the map of the products.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
public class InputValidator {

    /**
     * Method checks number given by user. Number value should be integer value from 1 to 5.
     *
     * @param number of the products given by user.
     * @return true if number is valid.
     * @throws BusinessException with information for the user that number is invalid if number is invalid.
     */
    public static boolean isNumberValid(String number) throws BusinessException {
        if(number.matches("[1-5]")) {
            return true;
        }
        throw new BusinessException("Invalid number!");
    }

    /**
     * Method checks name given by user. Name can contain only great and small letters or spaces.
     * There can't be two or more spaces one after another. There is also no possibility to start the name
     * from the space.
     *
     * @param name of the product given by user.
     * @return true if name is valid.
     * @throws BusinessException with information for the user that name is invalid if name is invalid.
     */
    public static boolean isNameValid(String name) throws BusinessException {
        if(name.matches("[a-zA-z]([a-zA-Z]|([ ][a-zA-Z]+))*")) {
            return true;
        }
        throw new BusinessException("Invalid product's name!");
    }

    /**
     * Method checks given by user price. Price can contain only numbers without any spaces.
     * There can be added also dot or comma to gives float value.
     *
     * @param price of the product given by user.
     * @return true if price is valid.
     * @throws BusinessException with information for the user that price format
     *                           is invalid if price format is invalid.
     */
    public static boolean isAmountValid(String price) throws BusinessException {
        if(price.matches("([0-9]+[,.]?[0-9]{0,2})|([,.][0-9]{0,2})")) {
            return true;
        }
        throw new BusinessException("Invalid product's price!");
    }

    /**
     * Method checks only the size of the map. Proper map should contain at least one
     * entry.
     *
     * @param dataOfProducts given by user in string format.
     * @return true if size of map is valid.
     * @throws BusinessException with information for the user that map
     *                           is invalid if map size is 0 or map equals null.
     */
    public static boolean isMapValid(Map<String, String> dataOfProducts) throws BusinessException {
        if(Objects.equals(null, dataOfProducts) || dataOfProducts.size() > 0) {
            return true;
        }
        throw new BusinessException("Invalid products' data map!");
    }

}
