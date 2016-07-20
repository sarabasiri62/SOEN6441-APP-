package ca.concordia.soen.advanced.resolvers;

import ca.concordia.soen.advanced.MathResolver;

public class NaiveApproximateResolver implements MathResolver {
    private int precision;

    public NaiveApproximateResolver(int precision) {
        this.precision = precision;
    }


    @Override
    public double sin(double x) {
        double approximation = x;

        for (int i = 1; i <= this.precision; i++) {
            if (i % 2 == 0)
                approximation += pow(x, 2 * i + 1) / factorial(2 * i + 1);
            else
                approximation -= pow(x, 2 * i + 1) / factorial(2 * i + 1);
        }

        return approximation;
    }

    @Override
    public double cos(double x) {
        double approximation = 1.0;

        for (int i = 1; i <= this.precision; i++) {
            if (i % 2 == 0)
                approximation += pow(x, 2*i) / factorial(2 * i);
            else
                approximation -= pow(x, 2*i) / factorial(2 * i);
        }

        return approximation;
    }

    @Override
    public double pow(double x, double y) {
        double result = 1.0;

        for(int i = 0; i < y; i++){
            result *= x;
        }

        return result;
    }

    @Override
    public double abs(double x) {
        if (x < 0)
            return -x;

        return x;
    }

    @Override
    public double pi() {
        double approximation = 1;
        int precision = 1000;
        double f; //TODO: Refactor this name

        for(int i = precision; i > 1; i--) {
            f = 2;
            for(int j = 1; j < i; j++){
                f = 2 + sqrt(f);
            }
            f = sqrt(f);
            approximation = approximation * f / 2;
        }
        approximation *= sqrt(2) / 2;
        approximation = 2 / approximation;

        return approximation;
    }

    private double factorial(int n) {
        if(n < 0) {
            throw new IllegalArgumentException();
        }

        double factorial = 1.0;

        for(int i = 2; i <= n; i++)
            factorial *= (double) i;

        return factorial;
    }
    private double sqrt(double x) {
        if(x < 0) {
            throw new IllegalArgumentException();
        }
        double approximation = (1 + x) / 2.0;
        double leastSquare = 0.0;

        while (approximation != leastSquare) {
            leastSquare = approximation;
            approximation = (approximation + x / approximation) / 2.0;
        }

        return approximation;
    }
}
