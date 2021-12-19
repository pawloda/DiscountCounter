package com.damian.discountcalculator.service;

import com.damian.discountcalculator.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class contains method creating from given string values entities of the product.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
public class ProductService {

    /**
     * Methods takes map with given information about products. In one entry there is
     * key - name of the product and value - price of the product. Method for every
     * entry takes these values and creates object by builder with poles name
     * and price.
     *
     * @param dataOfProducts given map with information about products.
     * @return list of products' entities.
     */
    protected List<Product> createProducts(Map<String, String> dataOfProducts) {
        List<Product> products = new ArrayList<>();
        for(Map.Entry<String, String> entry : dataOfProducts.entrySet()) {
            String price = entry.getValue().replace(",", ".");
            Product product = Product.builder()
                    .name(entry.getKey())
                    .price(Double.parseDouble(price))
                    .build();
            products.add(product);
        }
        return products;
    }

}
