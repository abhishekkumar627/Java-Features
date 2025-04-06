package com.abhishek.javainaction.chapter5.section5_5;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PracticeAll {
    public static void main(String[] args) {
        List<Transaction> transactionList = PracticeUtils.getTransactionsList();
        practiceExample1(transactionList);
        practiceExample2(transactionList);
        practiceExample3(transactionList);
        practiceExample4(transactionList);
        practiceExample5(transactionList);
        practiceExample6(transactionList);
        practiceExample7(transactionList);
        practiceExample8(transactionList);

    }

    private static void practiceExample8(List<Transaction> transactionList) {
        //Find the transaction with the smallest value.


        //using reduce
        Optional<Transaction> tran2 = transactionList.stream()
                .reduce((transaction1, transaction2) -> transaction1.getValue() < transaction2.getValue() ? transaction1 : transaction2);
        System.out.println(tran2);

        //using min
        Optional<Transaction> transaction = transactionList.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(transaction);

    }

    private static void practiceExample7(List<Transaction> transactionList) {
        //What’s the highest value of all the transactions?

        Integer highestVal = transactionList.stream()
                .map(Transaction::getValue)
//                .reduce(0,(x,y)->x>y?x:y);
                .reduce(0, Integer::max);
        System.out.println(highestVal);
    }

    private static void practiceExample6(List<Transaction> transactionList) {
        //Print all transactions’ values from the traders living in Cambridge.

        List<Integer> transactions =
                transactionList.stream()
                        .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge"))
                        .map(Transaction::getValue)
                        .collect(Collectors.toList());
        System.out.println(transactions);
    }

    private static void practiceExample5(List<Transaction> transactionList) {
        //Are any traders based in Milan?
        Optional<Transaction> anyMilanTrader = transactionList.stream()
                .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Milan"))
                .findAny();
        System.out.println(anyMilanTrader);

        boolean anyMilanTrader2 = transactionList.stream()
                .anyMatch(transaction -> Objects.equals(transaction.getTrader().getCity(), "Milan"));
        System.out.println(anyMilanTrader2);

    }

    private static void practiceExample4(List<Transaction> transactionList) {
        //Return a string of all traders’ names sorted alphabetically
        String stringOfNames = transactionList.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
//                .collect(Collectors.joining());
        System.out.println(stringOfNames);
    }

    private static void practiceExample3(List<Transaction> transactionList) {
        //Find all traders from Cambridge and sort them by name.
        List<Trader> tradersFromCambridge = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(tradersFromCambridge);

    }

    private static void practiceExample2(List<Transaction> transactionList) {
        //What are all the unique cities where the traders work?
        List<String> cities = transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);
    }

    private static void practiceExample1(List<Transaction> transactionList) {
        //Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> listOfTransactions = transactionList.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(listOfTransactions);

    }
}
