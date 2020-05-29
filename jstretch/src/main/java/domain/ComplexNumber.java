/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author julinden
 */
public class ComplexNumber {
    private double real;
    private double img;
    
    public ComplexNumber (double real, double img) { 
        this.real = real;
        this.img = img;
    }
    
    public ComplexNumber add(ComplexNumber x) {         
        double real = x.getReal() + this.real;
        double img = x.getImg() + this.img;
        return new ComplexNumber(real, img);
    }
    
    public ComplexNumber substract(ComplexNumber x) {         
        double real = this.real - x.getReal();
        double img = this.img - x.getImg();
        return new ComplexNumber(real, img);
    }
    
    public ComplexNumber multiply(ComplexNumber x) { 
        double real = this.real * x.getReal() - this.img * x.getImg();
        double img = this.real * x.getImg() + this.img * x.getReal();
        return new ComplexNumber(real, img);
    }
    
    public double getReal() {
        return real;
    }

    public double getImg() {
        return img;
    }
    
    @Override
    public String toString() { 
        return getReal() + " + " + getImg() + "i";
    }
 }
