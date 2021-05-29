package com.tms.Homework_12_TMS.Homework_12_TMS_ex1;

public class test {
    public static void main(String[] args) {
        MyCustomArray<String> testArray=new MyCustomArray<>();
        testArray.add("String0");
        testArray.add("String1");
        testArray.add("String2");
        testArray.add("String3");
        testArray.add("String4");
        testArray.add("String5");
        testArray.add(2,"String6");
        testArray.add(4,"String7");
        testArray.add(5,"String7");
        testArray.add(6,"String7");
        testArray.add(7,"String7");
        for (String item : testArray) {
            System.out.println(item);
        }
        System.out.println(testArray.size());
    }
}
