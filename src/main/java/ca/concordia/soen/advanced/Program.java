package ca.concordia.soen.advanced;

import ca.concordia.soen.advanced.resolvers.JavaApiResolver;
import ca.concordia.soen.advanced.resolvers.NaiveApproximateResolver;

public class Program {
    public static void main(String[] args) {
        Cheers cheersOne = new Cheers(new NaiveApproximateResolver(10));
        Cheers cheersTwo = new Cheers(new JavaApiResolver());

        double oneLength, twoLength;
        for(double radius = 1.0; radius < 100.0; radius += 1.0) {
            oneLength = cheersOne.length(radius);
            twoLength = cheersTwo.length(radius);
            System.out.println(String.format("One: %1$.20f, Two: %2$.20f, Dev: %3$.20f", oneLength, twoLength, oneLength - twoLength));
        }
    }
}
