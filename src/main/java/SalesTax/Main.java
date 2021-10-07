package SalesTax;

public class Main {
    public static void main(String[] args) {
        SalesTaxCalculator salesTaxCalculator =
                new SalesTaxCalculator("src/main/resources/input1.txt");
        salesTaxCalculator.salesTaxCalculator();

        System.out.println("Output 1");
         salesTaxCalculator.sendOutput();
                System.out.println();

        SalesTaxCalculator salesTaxCalculator2 =
                new SalesTaxCalculator("src/main/resources/input2.txt");
        salesTaxCalculator2.salesTaxCalculator();

        System.out.println("Output 2");
        salesTaxCalculator2.sendOutput();
        System.out.println();


        SalesTaxCalculator salesTaxCalculator3 =
                new SalesTaxCalculator("src/main/resources/input3.txt");
        salesTaxCalculator3.salesTaxCalculator();

        System.out.println("Output 3");
        salesTaxCalculator3.sendOutput();
        System.out.println();


    }
    }

