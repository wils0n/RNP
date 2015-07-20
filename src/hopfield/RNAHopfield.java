/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hopfield;

/**
 *
 * @author pytux
 */

import excepcion.ErrorRedNeuronal;
import matriz.BiPolarUtil;
import matriz.Matriz;
import matriz.MatrizMate;

public class RNAHopfield {
    private Matriz matrizPesos;
    
    public RNAHopfield(final int tamanno){
        this.matrizPesos = new Matriz(tamanno,tamanno);
    }
    
    public Matriz getMatriz(){
        return this.matrizPesos;
    }
    
    public int getTamanno(){
        return this.matrizPesos.getFilas();
    }
    
    public boolean[] presentar(final boolean[] patron){
        final boolean salida[] = new boolean[patron.length];
        
        final Matriz entradaMatriz = Matriz.crearMatrizFila(
                BiPolarUtil.bipolarAdouble(patron));
        
        for (int columna = 0; columna < patron.length; columna++){
            Matriz matrizColumna = this.matrizPesos.getColumna(columna);
            matrizColumna = MatrizMate.transpuesta(matrizColumna);
            
            final double prodPunto = MatrizMate.productoPunto
                    (entradaMatriz, matrizColumna);
            if (prodPunto > 0){
                salida[columna] = true;
            } 
            else
            {
                salida[columna] = false;
            }
        }
        return salida;
    } 
    
    public void entrenar(final boolean[] patron){
        if (patron.length != this.matrizPesos.getFilas()){
            throw new ErrorRedNeuronal("No se pude entrenar un patron"
                    + " de tamaño "+patron.length+"en una red de "
                    + "hopfield de tamaño "+this.matrizPesos.getFilas());
        }
        
        final Matriz m2 = Matriz.crearMatrizFila(
                BiPolarUtil.bipolarAdouble(patron));
        final Matriz m1 = MatrizMate.transpuesta(m2);
        final Matriz m3 = MatrizMate.multiplicar(m1, m2);
        
        final Matriz identidad = MatrizMate.identidad(m3.getFilas());
        
        final Matriz m4 = MatrizMate.restar(m3, identidad);
        
        this.matrizPesos = MatrizMate.sumar(this.matrizPesos, m4);
    }
}













