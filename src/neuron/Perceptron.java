/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuron;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manci
 */
public class Perceptron {

    private double Ws[];
    private double w0;
    private int Xs[][];
    private int x0;
    private double deltaMin;
    private int Yd[];
    private int Yobt[];
    private double grafECM[]; 
    private double ECMmin = 100;
    private double ECMmax = 0;
    private int epocasTrascurridas = 0;

    private void weightAssignment() {
        for (int i = 0; i < this.Xs[0].length; i++) {
            this.Ws[i] = Math.random();
        }
    }

    /* escalon */
    private int activatioFunStep(double z) {
        return z >= 0 ? 1 : 0;
    }

    private double activationValue(double W[], int X[]) {
        double z = 0;

        for (int i = 0; i < W.length; i++) {
            z += X[i] * W[i];
        }

        z += this.x0 * this.w0;

        return z;
    }

    private void updateWeights(int Yd, int Yobt, int x) {

        for (int i = 0; i < Ws.length; i++) 
            Ws[i] = Ws[i] + deltaMin * (Yd - Yobt) * x;
        
        w0 = w0 + deltaMin * (Yd - Yobt);
    }
    
    private double ecm (){
        double ECM;
        double sum = 0;
        double res;
        double m = 0;
        
        for (int i = 0; i<Yd.length; i++){
            sum+= Math.pow(Yobt[i] - Yd[i], 2);
        }
        m =1/(Yd.length*2);
        ECM = 0.5 * sum;
            
        return ECM;
    }

    public Perceptron(int Xs[][], int Yd[], double deltaMin, double w0, int x0) {
        this.Xs = Xs;
        this.Yd = Yd;
        this.Yobt = new int[Yd.length];
        this.deltaMin = deltaMin;
        this.w0 = w0;
        this.x0 = x0;
        this.Ws = new double[Xs[0].length];
        weightAssignment();
    }
    
    public void trainig(int epoch) {

        grafECM = new double[epoch];
        for (int i = 1; i <= epoch; i++) {
            System.out.println("Epoca: " + i);
            epocasTrascurridas = i;
            System.out.print("Yobt: ");
            for (int j = 0; j < Xs.length; j++) {
                double z = activationValue(Ws, Xs[j]);
                int y = activatioFunStep(z);
                this.Yobt[j] = y;
                System.out.print(y);
                if (y != Yd[j]) 
                    updateWeights(Yd[j], y, Yd[j]);
                
            }
            System.out.print("\nYd: ");
            for (int m : this.Yd)
                System.out.print(m);
            System.out.println();
            System.out.println(ecm());
            grafECM[i] = ecm();
            ECMmax = grafECM[i] > ECMmax ? grafECM[i] : ECMmax;  
            ECMmin = grafECM[i] < ECMmin ? grafECM[i] : ECMmin;
            if (ecm() <= 0.2){
                break;
            }
        }
    }
    
    public int classification(int x1, int x2) {
        int x[] = {x1,x2};
        double z = activationValue(Ws, x);
        int y = activatioFunStep(z);
        
        return y;
    }
    
    public void viewWeightsAndBias() {
        System.out.println("Pesos");
        for (double i : Ws) {
            System.out.print("W: " + i + " ");
        }
        
        System.out.println("\nBias");
        System.out.println("w: " + w0 + " x: " + x0);
    }
    
    public void graf(){
        System.out.println("Grafica para mostrar el error cuadratico medio");
        for (double i = ECMmax+0.1 ; i>0; i-=0.1){
            BigDecimal roundedValue = new BigDecimal(i-0.1).setScale(1, BigDecimal.ROUND_HALF_UP);
            if (roundedValue.doubleValue() < 0) break;
            System.out.print(roundedValue);
            for (int j = 0; j<epocasTrascurridas; j ++)
                if(grafECM[j] == roundedValue.doubleValue()){
                    System.out.print(" * ");
                }else {
                    System.out.print("   ");
                }
            System.out.println();
        }
        System.out.print("---");
        for (int e = epocasTrascurridas; e>0; e--)
                System.out.print("E"+e+"-");
    }

}
