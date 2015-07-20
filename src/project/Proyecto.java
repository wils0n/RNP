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
 * @author wil_jm
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
        
        final boolean[] patronA = image.getImageArray("A");
        final boolean[] patronB = image.getImageArray("B");
        final boolean[] patronC = image.getImageArray("C");
        final boolean[] patronD = image.getImageArray("D");
        final boolean[] patronE = image.getImageArray("E");
        final boolean[] patronF = image.getImageArray("F");
        final boolean[] patronG = image.getImageArray("G");
        final boolean[] patronH = image.getImageArray("H");
        final boolean[] patronI = image.getImageArray("I");
        final boolean[] patronJ = image.getImageArray("J");
        final boolean[] patronAtest = image.getImageArray("A_test");
        final boolean[] patronItest = image.getImageArray("I_test");
        
        
        System.out.println("Entrenamiento de la Red de Hopfield");
        red.entrenar(patronA);
        //red.entrenar(patronB);
        //red.entrenar(patronC);
        //red.entrenar(patronD);
        //red.entrenar(patronE);
        //red.entrenar(patronF);
        //red.entrenar(patronG);
        //red.entrenar(patronH);
        //red.entrenar(patronI);
        //red.entrenar(patronJ);
        //red.entrenar(patronA);
        //presentar patron1 y ver si este se reconoce
        boolean[] resultado1;
        boolean[] resultado2;
        resultado1 = red.presentar(patronA);
        //System.out.println("Presentando patron: \n" +formatearBoolean(patron1)+" y obteniendo \n" + formatearBoolean(resultado));
        
        resultado2 = red.presentar(patronAtest);
        System.out.println("Presentando patron: \n" +formatearBoolean(patronAtest)+" y obteniendo \n" + formatearBoolean(resultado2));
        
        boolean band=true;
        for (int i = 0; i < resultado2.length; i++) {
            if(resultado1[i]!=resultado2[i]){
                band=false;
                break;
            }
        }
        
        if (band){
            System.out.println("iguales");
        }else{
            System.out.println("diferentes");
        }
    }
    
}
