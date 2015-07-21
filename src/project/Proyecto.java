/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import hopfield.RNAHopfield;
import image.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Integrantes:
 * -----------
 *      Wilson Julca Mejia
 *      Steve Tovar Cabrera
 *      Aaron Rodriguez
 *      Antonio Vargar Vergaray
 */
public class Proyecto {
    
    //Ejemplo [V,V,F,F]
    public static String formatearBoolean(final boolean b[]){
        final StringBuilder resultado = new StringBuilder();
        resultado.append('[');
        for (int i=0; i < b.length; i++){
            if (b[i]){
                resultado.append("V");
            } else {
                resultado.append("F");
            }
            if (i != b.length-1)
                resultado.append(",");
        }
        resultado.append("]");
        return (resultado.toString());
    }
    
    public static void main(String[] args) throws IOException{
        final RNAHopfield red = new RNAHopfield(2750);
        Image image = new Image();
        
        Map<String, String> map = new HashMap<String, String>();
        String aux;
        
        final boolean[] patronA = image.getImageArray("A");
        map.put(Arrays.toString(patronA), "A");
        final boolean[] patronB = image.getImageArray("B");
        map.put(Arrays.toString(patronB), "B");
        final boolean[] patronC = image.getImageArray("C");
        map.put(Arrays.toString(patronC), "C");
        final boolean[] patronD = image.getImageArray("D");
        map.put(Arrays.toString(patronD), "D");
        final boolean[] patronE = image.getImageArray("E");
        map.put(Arrays.toString(patronE), "E");
        final boolean[] patronF = image.getImageArray("F");
        map.put(Arrays.toString(patronF), "F");
        final boolean[] patronG = image.getImageArray("G");
        map.put(Arrays.toString(patronG), "G");
        final boolean[] patronH = image.getImageArray("H");
        map.put(Arrays.toString(patronH), "H");
        final boolean[] patronI = image.getImageArray("I");
        map.put(Arrays.toString(patronI), "I");
        final boolean[] patronJ = image.getImageArray("J");
        map.put(Arrays.toString(patronJ), "J");
        final boolean[] patronAtest = image.getImageArray("A_test");
        final boolean[] patronItest = image.getImageArray("I_test");
        
        
        System.out.println("Entrenamiento de la Red de Hopfield");
        red.entrenar(patronA);
        red.entrenar(patronB);
        red.entrenar(patronC);
        red.entrenar(patronD);
        red.entrenar(patronE);
        red.entrenar(patronG);
        red.entrenar(patronA);
        red.entrenar(patronH);
        red.entrenar(patronI);
        red.entrenar(patronJ);
        red.entrenar(patronA);
        red.entrenar(patronH);
        red.entrenar(patronI);
        
        boolean[] resultado;
        System.out.println("=====");
        
        resultado = red.presentar(patronAtest);
        System.out.println("Test #1 se parece a la letra: "+ map.get(Arrays.toString(resultado)));
        
        resultado = red.presentar(patronItest);
        System.out.println("Test #2 se parece a la letra: "+ map.get(Arrays.toString(resultado)));
        
        
        
    }
    
}
