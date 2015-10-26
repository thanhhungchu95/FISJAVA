/**
 *  Class Complex
 *
 *  @author Chu Thanh Hung
 */

public class Complex {

    private double real;        // The real of complex number
    private double imaginary; // The imaginary of complex number

    /** 
     * Default constructor method 
     */
    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    /** 
     * Contructor method with two arguments 
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /** 
     * Copy constructor method 
     */
    public Complex(Complex c) {
        this.real = c.getReal();
        this.imaginary = c.getImaginary();
    }

    /** 
     * Setter method for real 
     */
    public void setReal(double real) {
        this.real = real;
    }

    /** 
     * Getter method for real 
     */
    public double getReal() {
        return this.real;
    }

    /** 
     * Setter method for imaginary 
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /** 
     * Getter method for imaginary 
     */
    public double getImaginary() {
        return this.imaginary;
    }

    /**
     * Return module of complex number
     */
    public double getModule() {
        return (Math.sqrt(real * real + imaginary * imaginary));
    }

    /**
     * Return argumen of complex number
     */
    public double getArgumen() {
        return (Math.atan(imaginary / real));
    }

    /**
     * Calculate sum of two complex number
     */
    public static Complex add(Complex c1, Complex c2) {
        double newReal = c1.getReal() + c2.getReal();
        double newImaginary = c1.getImaginary() + c2.getImaginary();

        return (new Complex(newReal, newImaginary));
    }

    /**
     * Calculate difference of two complex number
     */
    public static Complex subtract(Complex c1, Complex c2) {
        Complex negativeC2 = c2.getNegativeComplexNumber();

        return add(c1, negativeC2);
    }

    /**
     * Calculate multiple of two complex number
     */
    public static Complex multiple(Complex c1, Complex c2) {
        double newReal = c1.getReal() * c2.getReal()
                         - c1.getImaginary() * c2.getImaginary();
        double newImaginary = c1.getReal() * c2.getImaginary()
                                + c1.getImaginary() * c2.getReal();

        return (new Complex(newReal, newImaginary));
    }

    /**
     * Calculate divide of two complex number
     */
    public static Complex divide(Complex c1, Complex c2) {
        Complex conjugateC2 = c2.getConjugateComplexNumber();

        Complex mul = Complex.multiple(c1, conjugateC2);

        double denominator = c2.getModule() * c2.getModule();

        return (new Complex(mul.getReal() / denominator, 
                            mul.getImaginary() / denominator));
    }

    /** 
     * Print standard form of complex number
     */
    public void printStandardForm() {
        System.out.println(this.getReal() + " + " 
                           + this.getImaginary() + "i");
    }

    /**
     * Print trigonometry form of complex number
     */
    public void printTrigonometryForm() {
        System.out.println(this.getModule() + "(cos(" + this.getArgumen() + " + i sin" + this.getArgumen() + ")");
    }

    /**
     * Input: a + bi
     * Output: -a - bi
     */
    private Complex getNegativeComplexNumber() {
        Complex c = new Complex();

        c.setReal(- this.getReal());
        c.setImaginary(- this.getImaginary());

        return c;
    }

    /**
     * Input: a + bi
     * Output: a - bi
     */
    public Complex getConjugateComplexNumber() {
        return (new Complex(this.getReal(), - this.getImaginary()));
    }

    public static void main(String[] args) {
        // Empty 
    }
}
