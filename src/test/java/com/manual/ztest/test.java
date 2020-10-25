package com.manual.ztest;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
       final String str1 = "test123";
        String  str2;
        str2 = str1;



        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        str2 += "321";

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        System.out.println("===================");

        final int  [] arr1={1,2,3,4,5};
        int [] arr2 = new int [4];



        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
        arr1[0]=9;

        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println(Arrays.equals(arr1,arr2));


    }

}
