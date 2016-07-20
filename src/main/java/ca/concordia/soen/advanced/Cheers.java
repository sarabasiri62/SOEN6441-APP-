package ca.concordia.soen.advanced;

public class Cheers {
    private MathResolver mathResolver;

    public Cheers(MathResolver mathResolver) {
        this.mathResolver = mathResolver;
    }

    private double alpha(double firstGuess) {
        double HALF_PI = mathResolver.pi() / 2;
        double threshold = 1 / mathResolver.pow(10, 10);
        double approximation = firstGuess;

        double delta;
        do {
            approximation -= (approximation - mathResolver.sin(approximation) - HALF_PI) / (1 - mathResolver.cos(approximation));
            delta = mathResolver.abs(approximation - mathResolver.sin(approximation) - HALF_PI);
        } while(delta > threshold);

        return approximation;
    }

    public double length(double radius) {
        if(radius < 0) {
            throw new IllegalArgumentException();
        }
        return 2 * radius * (1 - mathResolver.cos(alpha(2) / 2));
    }
}
