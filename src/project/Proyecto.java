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

/**
 *
 * @author pytux
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
        final RNAHopfield red = new RNAHopfield(20000);
        Image image = new Image();
        
        final boolean[] patron1 = image.getImageArray("A");
        //final boolean[] patron2 = image.getImageArray("B");
        //final boolean[] patron3 = image.getImageArray("C");
        //final boolean[] patron4 = image.getImageArray("D");
        //final boolean[] patron5 = image.getImageArray("E");
        //final boolean[] patron6 = image.getImageArray("F");
        //final boolean[] patron7 = image.getImageArray("G");
        //final boolean[] patron8 = image.getImageArray("H");
        //final boolean[] patron9 = image.getImageArray("I");
        //final boolean[] patron10 = image.getImageArray("J");
        final boolean[] patrontest = image.getImageArray("A_test");
        
        
        System.out.println("Entrenamiento de la Red de Hopfield");
        red.entrenar(patron1);
        //red.entrenar(patron2);
        //red.entrenar(patron3);
        //red.entrenar(patron4);
        //red.entrenar(patron5);
        //red.entrenar(patron6);
        //red.entrenar(patron7);
        //red.entrenar(patron8);
        //red.entrenar(patron9);
        //red.entrenar(patron10);
        
        //presentar patron1 y ver si este se reconoce
        boolean[] resultado;
        resultado = red.presentar(patron1);
        System.out.println("Presentando patron: \n" +patron1+" y obteniendo\n " + resultado);
        
        //resultado = red.presentar(patrontest);
        
        
        
        
    }
    
}
