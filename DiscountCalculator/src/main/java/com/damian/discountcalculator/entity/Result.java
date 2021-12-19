package com.damian.discountcalculator.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.NumberFormat;

/**
 * Class of the result Entity.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
@Getter
@Setter
@Builder
public class Result {

    private String name;
    private double discount;

    /**
     * Method used to display the sentence including two poles from result class
     * in proper form ("Discount to product:
     * [product's name] = [discount value] [currency in region]".
     *
     * @return result information contains product's name and discount formatted
     * to currency instance in string.
     */
    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Discount to product: " + name + " = " + formatter.format(discount);
    }

}
