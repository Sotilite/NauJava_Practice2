package org.example;

import Tasks.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        executeTask1();
        executeTask2();
        executeTask3();
        executeTask4();
        executeTask5();
    }

    public static void executeTask1() {
        System.out.println("Running FIRST task");
        int[] array = { 4, -3, 943, -321, 9340, -2 };
        int lastPositiveElement = Task1.findLastPositiveElement(array);
        System.out.println("Last positive element: " + lastPositiveElement + "\n");
    }

    public static void executeTask2() {
        System.out.println("Running SECOND task");
        var list = new ArrayList<Double>();
        list.add(345.3);
        list.add(-32.6);
        list.add(32.0);
        list.add(-542.23);
        Task2.selectionSort(list);
        System.out.println("Sorted list: " + list + "\n");
    }

    public static void executeTask3() {
        System.out.println("Running THIRD task");
        var employeeList = Task3.Employee.getExampleList();
        var transformedList = employeeList.stream()
                .map(employee -> employee.getFullName() + " - "+ employee.getDepartment())
                .toList();
        System.out.println(transformedList + "\n");
    }

    public static void executeTask4() {
        System.out.println("Running FOURTH task");
        var urlAddress = "https://httpbin.org/anything";
        var key = "headers";
        var field = "Accept";
        var result = Task4.getFieldResultFromGetRequest(urlAddress, key, field);
        System.out.println(result + "\n");
    }

    public static void executeTask5() {
        System.out.println("Running FIFTH task");
        var task = new Task5.TaskProcessing();
        task.addPackage("first package");
        task.addPackage("second package");
        task.addPackage("third package");
        task.addPackage("fourth package");

        task.start();
        Task5.executeDelay(7);

        task.addPackage("fifth package");

        Task5.executeDelay(2);
        task.stop();
    }
}