package dev.dockeray.datastructures.ch1;

import java.util.Scanner;

public class InputAllBaseTypes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting...");

        System.out.println("Please enter a byte value");
        var bite = sc.nextByte();
        System.out.println("You entered: "+bite);

        System.out.println("Please enter a string value");
        var str = sc.next();
        System.out.println("You entered: "+str);

        System.out.println("Please enter a string value");
        var twin = sc.nextDouble();
        System.out.println("You entered: "+twin);

        sc.close();



    }

}
