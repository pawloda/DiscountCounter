package com.damian.discountcalculator;

import com.damian.discountcalculator.entity.Result;
import com.damian.discountcalculator.exception.BusinessException;
import com.damian.discountcalculator.service.ResultService;
import com.damian.discountcalculator.validator.InputValidator;

import java.util.*;

/**
 * Main class of the application.
 *
 * @author Damian
 * @version 1.0
 * @since 20.12.2021
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Method needed to start the application. It runs all necessary methods
     * and takes information from the user. It takes number of products,
     * creates map of strings with information about products, creates from
     * this map list of results and finally displays it.
     *
     * @param args strings table.
     */
    public static void main(String[] args) {
        System.out.println("\n*** Hello in Discount Calculator! ***\n\nPlease give input data.\n");
        int numberOfProducts = createNumberOfProducts();
        Map<String, String> dataOfProducts = createDataOfProducts(numberOfProducts);
        List<Result> results = new ArrayList<>();
        do {
            double discount = createDiscount();
            ResultService resultService = new ResultService();
            try {
                results = resultService.runService(dataOfProducts, discount);
            } catch(BusinessException exception) {
                System.out.print("Oh.. It's too much. Discount is as big as or bigger than sum of products' prices!");
            }
        } while(results.isEmpty());
        System.out.print("\n**********************\nHere are your results:\n");
        displayResults(results);
        scanner.close();
    }

    /**
     * It takes from user information about number of products.
     * The number can be between 1 and 5 - method checks this rule.
     * If user puts it wrong method will please again until it is validated.
     *
     * @return number of products in integer value.
     */
    private static int createNumberOfProducts() {
        String numberOfProducts;
        boolean validator = false;
        System.out.print("Input number of products (number from 1 to 5): ");
        do {
            numberOfProducts = scanner.nextLine();
            try {
                validator = InputValidator.isNumberValid(numberOfProducts);
            } catch(BusinessException exception) {
                System.out.print("Number incorrect! Please input value between 1 and 5 again: ");
            }
        } while(!validator);
        return Integer.parseInt(numberOfProducts);
    }

    /**
     * Method creates the map of information in strings depending on
     * taken number of products. Then it takes from user information about
     * every product (name, price) in proper format and validates them.
     *
     * @param numberOfProducts taken number of products.
     * @return map of information for every product in strings.
     */
    private static Map<String, String> createDataOfProducts(int numberOfProducts) {
        Map<String, String> dataOfProducts = new HashMap<>();
        for(int i = 0; i < numberOfProducts; i++) {
            String name = inputName(i);
            String price = inputPrice(i);
            dataOfProducts.put(name, price);
        }
        return dataOfProducts;
    }

    /**
     * Method takes from user name and validates it. If the name is incorrect it repeats
     * until user gives proper data.
     *
     * @param i integer value. Method is used inside loop. It is number of loops.
     * @return name in string.
     */
    private static String inputName(int i) {
        String name;
        boolean validator = false;
        System.out.print("\nInput name of " + (i + 1) + " product: ");
        do {
            name = scanner.nextLine();
            try {
                validator = InputValidator.isNameValid(name);
            } catch(BusinessException exception) {
                System.out.print("Invalid name! You can use only " +
                        "letters and single spaces. Please put it again: ");
            }
        } while(!validator);
        return name;
    }

    /**
     * Method takes from user price and validates it. If the price is incorrect it repeats
     * until user gives proper data.
     *
     * @param i integer value. Method is used inside loop. It is number of loops.
     * @return price in string.
     */
    private static String inputPrice(int i) {
        String price;
        boolean validator = false;
        System.out.print("Input price of " + (i + 1) + " product (without spaces): ");
        do {
            price = scanner.nextLine();
            try {
                validator = InputValidator.isAmountValid(price);
            } catch(BusinessException exception) {
                System.out.print("Invalid price! You can use only " +
                        "integers and one dot or comma. Please put it again: ");
            }
        } while(!validator);
        return price;
    }

    /**
     * Method takes from user information about the summary discount value and validates it.
     * If the amount is incorrect it repeats until user gives proper data.
     *
     * @return summary discount value in double format.
     */
    private static double createDiscount() {
        String discount;
        boolean validator = false;
        System.out.print("\nInput discount for products (without spaces and smaller than summary price): ");
        do {
            discount = scanner.nextLine();
            try {
                validator = InputValidator.isAmountValid(discount);
            } catch(BusinessException exception) {
                System.out.print("Invalid discount's value! You can use only " +
                        "integers and one dot or comma. Please put it again: ");
            }
        } while(!validator);
        return Double.parseDouble(discount);
    }

    /**
     * Method displays objects of results.
     *
     * @param results list of results.
     */
    private static void displayResults(List<Result> results) {
        for(Result result : results) {
            System.out.println("\n" + result);
        }
        System.out.println("\nThank you for using!!!\n**********************");
    }

}
