/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import hopfield.RNAHopfield;

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
    public static void main(String[] args){
        final RNAHopfield red = new RNAHopfield(9);
        
        final boolean[] patron1 = {true,true,true,true, false, true, true, true, true};
        final boolean[] patron2 = {true, false, true, false, true, false, true, false, true};
        final boolean[] patron3 = {true,true,true,true, false, true, true, true, true};
        final boolean[] patron4 = {true, false, true, false, false, false, true, false, true};
        final boolean[] patrontest = {false, true, false, true, true, true, false, true, false};
        
        boolean[] resultado;
        
        System.out.println("Entrenamiento de la Red de Hopfield"
                + " con: " + formatearBoolean(patron1) + " y "
                + formatearBoolean(patron2));
        red.entrenar(patron1);
        red.entrenar(patron2);
        red.entrenar(patron3);
        red.entrenar(patron4);
        /*red.entrenar(patron1);
        red.entrenar(patron2);
        red.entrenar(patron1);
        red.entrenar(patron2);
        red.entrenar(patron1);
        red.entrenar(patron2);
        red.entrenar(patron1);*/
        
        //presentar patron1 y ver si este se reconoce
        
        resultado = red.presentar(patron1);
        System.out.println("Presentando patron: "
                +formatearBoolean(patron1)+
                " y obteniendo " + formatearBoolean(resultado));
        
        resultado = red.presentar(patrontest);
        System.out.println("Presentando patron: "
                +formatearBoolean(patrontest)+
                " y obteniendo " + formatearBoolean(resultado));
        
        
        
    }
    
}
