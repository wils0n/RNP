/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author pytux
 */
public class Image {
    private BufferedImage imageActual;
    
    public void openImage(String value) throws FileNotFoundException, IOException{
        BufferedImage bmp=null;
        value = value+".JPG";
        File f = new File("set1/"+value);
        bmp = ImageIO.read(f);
        imageActual = bmp;        
        
    }
    
    public ArrayList getArrayList(){
    
        Color colorAux;
        ArrayList<Color> colorsPixel = new ArrayList();
                
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                colorsPixel.add(colorAux);
            }
        }
        
        ArrayList<Boolean> colors = new ArrayList<Boolean>();
        
        
        for (Color i: colorsPixel) {
            if (evaluateCode(i)){
                colors.add(true);
            }else{
                colors.add(false);
            }
        }
        return colors;
    }
    
    private boolean evaluateCode(Color pix){
        if ((pix.getRed() - 10 > 237) && (pix.getGreen() - 10 > 237) && (pix.getBlue() - 10 > 237)){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean[] getImageArray(String value) throws IOException{
        this.openImage(value);
        ArrayList<Boolean> patron = new ArrayList<Boolean>();
        patron = this.getArrayList();
        
        boolean[] color = new boolean[20000];
        
        for (int i = 0; i < patron.size(); i++) {
            color[i] = patron.get(i);
        }
        return color;
    }
    
    /*
    public static void main(String[] args) throws IOException {
        boolean[] color = new boolean[20000];
        Image img = new Image();
        color = img.getImageArray("A");
           
    }
    */
}
