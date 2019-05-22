package javase;

import java.util.Arrays;

public class triangle {
    static String[] kind = {"General triangle", "Isosceles triangle", "Equilateral triangle", "Not a triangle"};
    static String isTriangle(double a, double b, double c) {
        double[] weights = new double[3];
        weights[0] = a;
        weights[1] = b;
        weights[2] = c;
        Arrays.sort(weights);
        if (weights[0] + weights[1] > weights[2] && weights[2] - weights[1] < weights[0]) {
            if (weights[0] == weights[1] && weights[1] == weights[2]) {
                return kind[2];
            }
            else if (weights[0] == weights[1] || weights[1] == weights[2]) {
                return kind[1];
            }
            else {
                return kind[0];
            }
        }
        return kind[3];
    }
    public static void main(String[] args) {
        double a = 5, b = 4.5, c = 1;
        System.out.println(isTriangle(a, b, c));
    }
}
