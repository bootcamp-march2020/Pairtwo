package com.bootcamp.test.part1;

import java.util.List;

class Item {
    double getPrice() {
        return 0;
    }
}

class Customer {
    String name;
    int age;
    long bill;
    List<Item> listsOfItems;

    Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Calculate bill should not be responsibility of customer
    public long calculateBill(long tax) {
        for (Item item : listsOfItems) {
            bill += item.getPrice();
        }
        bill += tax;
        this.setBill(bill);
        return bill;
    }

    //Report generation should not be responsibility of customer
    public void generateReport(String reportType) {
        if (reportType.equalsIgnoreCase("CSV")) {
            System.out.println("Generate CSV report");
        }
        if (reportType.equalsIgnoreCase("XML")) {
            System.out.println("Generate XML report");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getBill() {
        return bill;
    }

    public void setBill(long bill) {
        this.bill = bill;
    }

    public List<Item> getListsOfItems() {
        return listsOfItems;
    }

    public void setListsOfItems(List<Item> listsOfItems) {
        this.listsOfItems = listsOfItems;
    }
}
