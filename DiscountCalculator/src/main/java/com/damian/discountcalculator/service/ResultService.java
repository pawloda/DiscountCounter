package com.damian.discountcalculator.service;

import com.damian.discountcalculator.entity.Product;
import com.damian.discountcalculator.entity.Result;
import com.damian.discountcalculator.exception.BusinessException;
import com.damian.discountcalculator.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class contains methods creating from given string values and discount
 * results in form of a list of results' entities. It uses also method from
 * product service.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
public class ResultService {

    ProductService productService = new ProductService();

    /**
     * Main method of the service. It creates list of results' entities
     * from given map with information about products and discount value.
     * It counts the discount value for every product. It keeps proportion
     * between products' discounts and summary discount to products' prices
     * and main price.
     *
     * @param dataOfProducts given in strings given by user during application work.
     * @param discount       given by user in proper format (only numbers and one
     *                       comma/dot.
     * @return list of results' entities.
     * @throws BusinessException if discount is bigger or equal sum of prices.
     */
    public List<Result> runService(Map<String, String> dataOfProducts, double discount) {
        InputValidator.isMapValid(dataOfProducts);
        List<Product> products = productService.createProducts(dataOfProducts);
        return getResults(products, discount);
    }

    /**
     * Method takes list of the products' entities and summary discount value.
     * It calculates sum of prices for products from list by calculate sum of prices method
     * (this sum is used to calculate discount for every product).
     * Then calculates the value of discount for every product by calculate product
     * discount method. In the end it creates list of results' entities. One object
     * of this class contain name and discount of one product from list.
     *
     * @param products taken list of products' entities.
     * @param discount taken summary discount value in double.
     * @return list of results' entities.
     * @throws BusinessException if discount is bigger or equal sum of prices.
     */
    private List<Result> getResults(List<Product> products, double discount) {
        List<Result> results = new ArrayList<>();
        double sumOfPrices = calculateSumOfPrices(products);
        if(discount >= sumOfPrices) {
            throw new BusinessException("To big discount!");
        }
        for(Product product : products) {
            results.add(Result.builder()
                    .name(product.getName())
                    .discount(calculateProductDiscount(sumOfPrices, product, discount))
                    .build());
        }
        return results;
    }

    /**
     * Methods takes list of the products' entities and calculate
     * sum of theirs prices.
     *
     * @param products taken list of the products' entities.
     * @return sum of products' prices in double format.
     */
    private double calculateSumOfPrices(List<Product> products) {
        double sumOfPrices = 0;
        for(Product product : products) {
            sumOfPrices += product.getPrice();
        }
        return sumOfPrices;
    }

    /**
     * It calculate discount for given product by these schema:
     * product's discount = (product's price : sum of the products' prices) x summary discount.
     *
     * @param sumOfPrices taken sum of all products' prices. Necessary to calculate proportion.
     * @param product     given to calculate discount.
     * @param discount    taken summary value.
     * @return discount value for given product.
     */
    private double calculateProductDiscount(double sumOfPrices, Product product, double discount) {
        return (product.getPrice() / sumOfPrices) * discount;
    }

}
