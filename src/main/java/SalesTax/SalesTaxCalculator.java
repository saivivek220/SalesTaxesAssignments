package SalesTax;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesTaxCalculator {

    private double totalCost;
    private double totalTax;

    private ArrayList<Product> productsList = new ArrayList<Product>();

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }


    public SalesTaxCalculator(String inputFile) {
        try {

            Scanner input = new Scanner(System.in);
            File file = new File(inputFile);
            input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();

                String[] words = line.split(" ");

                int qty = Integer.parseInt(words[0]);

                boolean isImported = line.contains("imported");

                String[] exemptedItems = new String[]{"book", "chocolate", "pills"};

                int itemsExempted = containsItemFromArray(line, exemptedItems);

                String exemptedCategory = null;

                if (itemsExempted != -1) {
                    exemptedCategory = exemptedItems[itemsExempted];

                }

                int splitIndex = line.lastIndexOf("at");

                if (splitIndex == -1) {

                    System.out.println("Invalid ");

                } else {

                    double price = Double.parseDouble((line.substring(splitIndex + 2)));
                    String name = line.substring(1, splitIndex);

                    for (int i = 0; i < qty; i++) {

                        Product product = null;

                        if (isImported) {
                            if (exemptedCategory != null) {

                                if (exemptedCategory == "book") {
                                    product = new Product(name, price, Category.BOOKS_IMPORTED);
                                }  else if (exemptedCategory == "chocolate") {
                                    product = new Product(name, price, Category.FOOD_IMPORTED);
                                }
                                else if (exemptedCategory == "pills") {
                                    product = new Product(name, price, Category.MEDICICAL_PRODUCTS_IMPORTED);
                                }

                            } else {
                                product = new Product(name, price, Category.OTHERS_IMPORTED);
                            }

                        } else {
                            if (exemptedCategory != null) {

                                if (exemptedCategory == "book") {
                                    product = new Product(name, price, Category.BOOK);
                                }
                                else if (exemptedCategory == "chocolate") {
                                    product = new Product(name, price, Category.FOOD);
                                }
                                else if (exemptedCategory == "pills") {
                                    product = new Product(name, price, Category.MEDICAL_PRODUCTS);
                                }

                            }  else {
                                product = new Product(name, price, Category.OTHERS);
                            }
                        }

                        productsList.add(product);
                    }
                }

            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void salesTaxCalculator() {

        int items = productsList.size();
        double tempPrice = 0.0d;
        double tempTax = 0.0d;

        for (int i = 0; i < items; i++) {

            tempTax = 0;

            double initialCost = this.productsList.get(i).getPrice();

            tempPrice = tempPrice + initialCost;

            if (productsList.get(i).isTaxable()) {
                double salesTaxPercent = 0.10d;
                double salesTax = salesTaxPercent * initialCost;

                salesTax = salesTax;
                tempTax = tempTax+ salesTax;


            }


            if (productsList.get(i).isImportedAndTaxable()) {

                double importDutyPercent = 0.05d;
                double importDuty = importDutyPercent * initialCost;

                importDuty = importDuty;
                tempTax = tempTax + importDuty;

            }


            productsList.get(i).setPrice(tempTax + productsList.get(i).getPrice());

            totalTax += tempTax;

            tempPrice = tempPrice + tempTax;
        }

        totalTax = totalTax;
        totalCost =tempPrice;
    }

    public static int containsItemFromArray(String inputString, String[] items) {
        int index = -1;

        for (int i = 0; i < items.length; i++) {

            index = inputString.indexOf(items[i]);

            if (index != -1)
                return i;

        }
        return -1;

    }

    public void sendOutput() {
        int numOfItems = productsList.size();
        for (int i = 0; i < numOfItems; i++) {
            System.out.println("1" + productsList.get(i).getProductName() + "at " + productsList.get(i).getPrice());
        }
        System.out.println("Sales Taxes : " + totalTax);
        System.out.println("Total: " + totalCost);
    }

}