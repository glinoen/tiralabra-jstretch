/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.io.File;
import java.io.IOException;
import java.lang.Math.*;
import java.util.Arrays;
import javax.sound.sampled.*;

/**
 *
 * @author julinden
 */
public class FFT {
    
    private final double pi = Math.PI;
    private final ComplexNumber Img = new ComplexNumber(0,1);
    
    public FFT() { 
        
    }
    
    public static ComplexNumber[] FFTRecursive(ComplexNumber[] input) { 
        int inputLength = input.length;
        
        if (inputLength == 1) { 
            return new ComplexNumber[] { input[0] };
        }
        
        ComplexNumber[] even = new ComplexNumber[inputLength/2];
        ComplexNumber[] odd = new ComplexNumber[inputLength/2];
        
        for (int k = 0; k < inputLength/2; k++) {
            even[k] = input[2*k];
            odd[k] = input[2*k + 1];
        } 
        
        ComplexNumber[] evenAfterFFT = FFTRecursive(even);
        ComplexNumber[] oddAfterFFT = FFTRecursive(odd);
        
        ComplexNumber[] combinedResult = new ComplexNumber[inputLength];
        for (int k = 0; k<inputLength/2; k++) {
            double angle = -2.0 * k * Math.PI / (double) inputLength;
            System.out.println(angle);
            ComplexNumber wK = new ComplexNumber(Math.cos(angle), Math.sin(angle));
            combinedResult[k] = evenAfterFFT[k].add(wK.multiply(oddAfterFFT[k]));
            combinedResult[k + inputLength/2] = evenAfterFFT[k].substract(wK.multiply(oddAfterFFT[k]));
        }
        return combinedResult;
    }
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException { 
        int[] inputti = new int[] { 0,1,0,0,0,0,0,0 };
        ComplexNumber[] x = new ComplexNumber[inputti.length];
        System.out.println(Arrays.toString(inputti));
        for (int i = 0; i < inputti.length; i++) { 
            x[i] = new ComplexNumber(inputti[i], 0);
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(FFTRecursive(x)));
        AudioInputStream ais = AudioSystem.getAudioInputStream(new File("/home/julinden/Downloads/520495__dottyyumyum__metallic-ting.wav"));
        System.out.println(ais.getFormat());
    }
}
