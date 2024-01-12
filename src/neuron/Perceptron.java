/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neuron;

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

    private void updateWeights(int Yd, int Yobt) {

        for (int i = 0; i < Ws.length; i++) 
            Ws[i] = Ws[i] + deltaMin + (Yd - Yobt);
        
        w0 = w0 + deltaMin + (Yd - Yobt);
    }
    
    private double ecm (){
        double ECM = 0;
        double [] sum = new double[2];
        double res = 0;
        
        for (int i = 0; i<Yd.length; i++){
            sum[0]+=Yd[i];
            sum[1]+=Yobt[i];
        }
        
        res = sum[1] - sum[0];
        
        ECM = 0.5 * Math.pow(res, 2);
            
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

        for (int i = 1; i <= epoch; i++) {
            System.out.println("Epoca: " + i);
            System.out.print("Yobt: ");
            for (int j = 0; j < Xs.length; j++) {
                double z = activationValue(Ws, Xs[j]);
                int y = activatioFunStep(z);
                this.Yobt[j] = y;
                System.out.print(y);
                if (y != Yd[j]) 
                    updateWeights(Yd[j], y);
            }
            System.out.print("\nYd: ");
            for (int m : this.Yd)
                System.out.print(m);
            System.out.println();
            
            if (ecm() <= 0.2){
                break;
            }
        }
        
        
    }

}
