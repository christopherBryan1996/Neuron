/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package neuron;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manci
 */
public class Neuron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int Xs[][] = {{0,0},
                      {0,1},
                      {1,0},
                      {1,1}};
        int Yd[] = {0,0,0,1};
        
        Perceptron perceptron = new Perceptron(Xs, Yd, 0.3, -5.8, 1);
        perceptron.trainig(10);
        
        int classi = perceptron.classification(1, 1);
        
        System.out.println("El resultado de clasificacion: " + classi);
        
        perceptron.viewWeightsAndBias();
        
        perceptron.graf();
    }
    
}
