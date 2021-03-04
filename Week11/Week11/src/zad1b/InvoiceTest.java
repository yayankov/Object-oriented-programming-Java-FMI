package zad1b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceTest {
    public static void main(String[] args) {
        Invoice[] invoices = {
                new Invoice(83, "Electric sander", 7, 57.98),
                new Invoice(24, "Power saw", 18, 99.99),
                new Invoice(7, "Sledge hammer", 11, 21.50),
                new Invoice(77, "Hammer", 76, 11.99),
                new Invoice(39, "Lawn mower", 3, 79.50),
                new Invoice(68, "Screwdriver", 106, 6.99),
                new Invoice(56, "Jig saw", 21, 11.00),
                new Invoice(3, "Wrench", 34, 7.50)
        };

        //a
        System.out.println("Invoices sorted by part description:");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(
                        Invoice::getPartDescription))
                .forEach(System.out::println);

        //b
        System.out.println("\nInvoices sorted by price:");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(
                        Invoice::getPrice))
                .forEach(System.out::println);

        //c
        System.out.println("\nInvoices" +
                " mapped to description and quantity:");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(
                        Invoice::getQuantity))
                .map(invoice -> String.format(
                        "Description: %-15s Quantity: %d",
                        invoice.getPartDescription(),
                        invoice.getQuantity()
                ))
                .forEach(System.out::println);

        //d
        System.out.println("\nInvoices" +
                " mapped to description and invoice amount:");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(
                        invoice -> invoice.getQuantity() *
                        invoice.getPrice()))
                .map(invoice -> String.format(
                        "Description: %-15s Invoice amount: %7.2f",
                        invoice.getPartDescription(),
                        invoice.getQuantity() * invoice.getPrice()
                ))
                .forEach(System.out::println);

        //e
        System.out.println("\nInvoices" +
                " mapped to description and invoice amount" +
                " in the range 200$ - 500$:");
        Arrays.stream(invoices)
                .filter(invoice -> invoice.getQuantity() *
                        invoice.getPrice() >= 200 &&
                        invoice.getQuantity() *
                                invoice.getPrice() <= 500)
                .sorted(Comparator.comparing(
                        invoice -> invoice.getQuantity() *
                                invoice.getPrice()))
                .map(invoice -> String.format(
                        "Description: %-15s Invoice amount: %7.2f",
                        invoice.getPartDescription(),
                        invoice.getQuantity() * invoice.getPrice()
                ))
                .forEach(System.out::println);

        //f
        System.out.println("\nInvoices" +
                " grouped below and above 300$ invoice value:");

        Map<String, List<Invoice>> groupedByInvoiceValue =
                Arrays.stream(invoices)
                    .collect(Collectors.groupingBy(
                        x -> x.getPrice() * x.getQuantity() <= 300?
                                "Below 300" : "Above 300"));

        groupedByInvoiceValue.forEach(
                (key, value) -> {
                    System.out.println(key);
                    value.forEach( invoice -> System.out.println(invoice));
                }
        );
    }
}
