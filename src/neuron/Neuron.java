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
    
    private static int[] flatten (int image[][]) {
        int[] arrayRes = new int[image.length* image[0].length];
        int i = 0;
        for (int array[] : image){
            for (int j = 0; j<array.length ; j++){
                arrayRes[i]=array[j];
                i++;
            }
        }
        
        return arrayRes;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int Xs[][] = {{0,0},
                      {0,1},
                      {1,0},
                      {1,1}};
        int Yd[] = {0,0,0,1};
        
        int imageOne[][] = {
            {1,1,1,1,1,0,1,1,1},
            {1,1,1,1,0,0,1,1,1},
            {1,1,1,0,1,0,1,1,1},
            {1,1,1,1,1,0,1,1,1},
            {1,1,1,1,1,0,1,1,1},
            {1,1,1,1,1,0,1,1,1},
            {1,1,1,1,1,0,1,1,1},
            {1,1,1,1,0,0,0,1,1},
            {1,1,1,1,1,1,1,1,1}
        };
        int imageZero[][] = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,0,0,0,0},
            {0,0,1,0,0,1,0,0,0},
            {0,0,1,0,0,0,1,0,0},
            {0,0,1,0,0,0,1,0,0},
            {0,0,1,0,0,0,1,0,0},
            {0,0,1,0,0,0,1,0,0},
            {0,0,1,0,0,1,0,0,0},
            {0,0,0,1,1,0,0,0,0}
        };
        int imageOne1[][] = {
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,1}
        };

        int imageZero2[][] = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,0,0,0},
            {0,0,0,1,0,0,1,0,0},
            {0,0,0,1,0,0,0,1,0},
            {0,0,0,1,0,0,0,1,0},
            {0,0,0,1,0,0,0,1,0},
            {0,0,0,1,0,0,0,1,0},
            {0,0,0,1,0,0,1,0,0},
            {0,0,0,0,1,1,0,0,0}
        };
         
        int imageZero3[][] = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,0,0,0,0},
            {0,0,0,1,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,1,0,0},
            {0,0,0,1,0,0,0,1,0,0},
            {0,0,0,1,0,0,0,1,0,0},
            {0,0,0,1,0,0,0,1,0,0},
            {0,0,0,1,0,0,1,0,0,0},
            {0,0,0,0,1,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
        };
         
         
        int imageOneTest[][] = {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,1,1,1,1},
            {1,1,1,0,1,0,1,1,1,1},
            {1,1,0,1,1,0,1,1,1,1},
            {1,1,1,1,1,0,1,1,1,1},
            {1,1,1,1,1,0,1,1,1,1},
            {1,1,1,1,1,0,1,1,1,1},
            {1,1,1,1,1,0,1,1,1,1},
            {1,1,1,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}
        };
         int imageZeroTest[][] = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,0},
            {0,1,0,0,1,0,0,0,0,0},
            {0,1,0,0,0,1,0,0,0,0},
            {0,1,0,0,0,1,0,0,0,0},
            {0,1,0,0,0,1,0,0,0,0},
            {0,1,0,0,0,1,0,0,0,0},
            {0,1,0,0,1,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
        };
        
        int YImage[] = {1,0,1,0,0};
         
        int xImage[][] = new int[5][imageOne.length* imageOne[0].length];
        
        xImage[0] = flatten(imageOne);
        xImage[1] = flatten(imageZero);
        xImage[2] = flatten(imageOne1);
        xImage[3] = flatten(imageZero2);
        xImage[4] = flatten(imageZero3);
        
        System.out.println("AND");
        
        Perceptron perceptron = new Perceptron(Xs, Yd, 0.3, -5.8, 1);
        perceptron.trainig(10);
        
        int[] test = {1,1};
        
        int classi = perceptron.classification(test);
        
        System.out.println("El resultado de clasificacion: " + classi);
        
        perceptron.viewWeightsAndBias();
        
        perceptron.graf();
        
        System.out.println("Imagen\n");
        Perceptron perceptronImg = new Perceptron(xImage, YImage, 0.9, -1, 1);
        perceptronImg.trainig(150);
        
        System.out.println();
        System.out.println(perceptronImg.classification(flatten(imageOneTest)));
        System.out.println(perceptronImg.classification(flatten(imageZeroTest)));
        
        perceptronImg.viewWeightsAndBias();
        
        perceptronImg.graf();
    }
    
    
}
