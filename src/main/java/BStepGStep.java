// Credits to Ahnaf and Chuck for the help.

package main.java;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BStepGStep {

    public static void main(String[] args) {


        // Used Ahnaf and Chuck's p, g and A value together to get their 'a'. Then used my
        // p, g and their B value to get their 'b'.

        System.out.println("Ahnaf and Chuck's 'a':");
        System.out.println(bStepGStep(BigInteger.valueOf(23834099), BigInteger.valueOf(3), BigInteger.valueOf(11284508)));

        System.out.println("Ahnaf and Chuck's 'b':");
        System.out.println(bStepGStep(BigInteger.valueOf(20000339), BigInteger.valueOf(3), BigInteger.valueOf(2401221)));

        // Used David's p, g and A value together to get his 'a'. Then used his p, g and Avery
        // and Kai's B value to get his 'b'.

        System.out.println("David's 'a':");
        System.out.println(bStepGStep(BigInteger.valueOf(35530787), BigInteger.valueOf(2), BigInteger.valueOf(30328638)));

        System.out.println("David's 'b':");
        System.out.println(bStepGStep(BigInteger.valueOf(35530787), BigInteger.valueOf(2), BigInteger.valueOf(28406022)));

        // Used Avery and Kai's p, g and A value together to get their 'a'. Then used his p, g
        // and David's B value to get their 'b'.

        System.out.println("Avery and Kai's 'a':");
        System.out.println(bStepGStep(BigInteger.valueOf(658996103), BigInteger.valueOf(5), BigInteger.valueOf(213962984)));

        System.out.println("Avery and Kai's 'b':");
        System.out.println(bStepGStep(BigInteger.valueOf(658996103), BigInteger.valueOf(5), BigInteger.valueOf(170879926)));


    }

    /**
     * @param groupsP This is the groups p value
     * @param groupsG This is the groups g value
     * @param groupsAorB This is the groups A or B value
     * @return a or b
     */

    private static BigInteger bStepGStep(BigInteger groupsP, BigInteger groupsG, BigInteger groupsAorB) {

        BigInteger bigI = sqrt(groupsP.subtract(BigInteger.valueOf(1)));

        Map<Integer, BigInteger> valuesOfAlpha = new HashMap<>();

        for (int j = 0; j < bigI.intValue(); j++) {

            BigInteger alphaPowJ = groupsG.modPow(BigInteger.valueOf(j), groupsP);
            valuesOfAlpha.put(j, alphaPowJ);

        }

        BigInteger inverseBigI = groupsG.modPow(bigI.multiply(groupsP.subtract(BigInteger.valueOf(2))), groupsP);

        for (int i = 0; i < bigI.intValue(); i++) {
            BigInteger y = (groupsAorB.multiply(inverseBigI.modPow(BigInteger.valueOf(i), groupsP))).mod(groupsP);
            for (Map.Entry<Integer, BigInteger> entry : valuesOfAlpha.entrySet()) {
                if (y.equals(entry.getValue())) {

                    return (bigI.multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(entry.getKey())));
                }
            }
        }
        return null;
    }

    private static BigInteger sqrt(BigInteger n) {

        BigInteger q0 = BigInteger.ONE;
        BigInteger q1 = n.shiftRight(5).add(BigInteger.valueOf(8));

        while (q1.compareTo(q0) >= 0) {

            BigInteger middle = q0.add(q1).shiftRight(1);

            if (middle.multiply(middle).compareTo(n) > 0) {
                q1 = middle.subtract(BigInteger.ONE);
            } else {
                q0 = middle.add(BigInteger.ONE);
            }
        }
        return q0.subtract(BigInteger.ONE);
    }
}