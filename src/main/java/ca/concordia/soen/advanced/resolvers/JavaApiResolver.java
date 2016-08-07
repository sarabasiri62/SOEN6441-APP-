package ca.concordia.soen.advanced.resolvers;

import ca.concordia.soen.advanced.MathResolver;

public class JavaApiResolver implements MathResolver {

    @Override
    public double sin(double x) {
        return Math.sin(x);
    }

    @Override
    public double cos(double x) {
        return Math.cos(x);
    }

    @Override
    public double pow(double x, double y) {
        return Math.pow(x, y);
    }

    @Override
    public double abs(double x) {
        return Math.abs(x);
    }

    @Override
    public double pi() {
        return Math.PI;
    }

}
