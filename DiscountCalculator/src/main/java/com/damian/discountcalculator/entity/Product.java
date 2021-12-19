package com.damian.discountcalculator.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
public class Product {

    private String name;
    private double price;

}
