package main.java;

import java.math.BigInteger;


// q = 10000169
// p = 20000339
// g = 3
// a = 74
// b = 189


// Ahnaf and Chuck's values
// p = 23834099
// g = 3
// A = 11284508
// B = 2401221

public class DiffieHellman {

    public static void main (String[] args) {

        // Method to find my value for q.

        /*int low = 10000000, high = 1000000000;
        while (low < high) {
            boolean flag = false;
            for(int i = 2; i <= low/2; ++i) {
                // condition for nonprime number
                if(low % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.print(low + " ");
            ++low;
        }*/


        // Check if p is prime.

        BigInteger bi;
        Boolean b1;

        bi = new BigInteger("20000339");
        b1 = bi.isProbablePrime(1);

        System.out.println("The key I chose is prime. True? " + b1);


        // My value declarations

        BigInteger p = BigInteger.valueOf(20000339);
        BigInteger g = BigInteger.valueOf(3);

        BigInteger jPr1 = BigInteger.valueOf(74);
        BigInteger jPr2 = BigInteger.valueOf(189);


        // My B value

        System.out.println("B:");
        System.out.println(g.modPow(jPr1, p));

        // My A value

        System.out.println("A:");
        System.out.println(g.modPow(jPr2, BigInteger.valueOf(23834099)));

        // First Shared Key

        System.out.println("First Shared Key:");
        System.out.println(BigInteger.valueOf(11284508).modPow(jPr1, p));

        // Second Shared Key

        System.out.println("Second Shared Key:");
        System.out.println(BigInteger.valueOf(32152315).modPow(jPr2, BigInteger.valueOf(23834099)));
    }
}