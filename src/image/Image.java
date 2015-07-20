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
    
    public void openImage() throws FileNotFoundException, IOException{
        BufferedImage bmp=null;
        File f = new File("set1/A.JPG");
        bmp = ImageIO.read(f);
        imageActual = bmp;        
        
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
        //Retornamos la imagen
        
        for (Color i: colorsPixel) {
            System.out.println(i.getRed() +" - " + i.getGreen() +" "+ i.getBlue());
        }
    }
    
    public static void main(String[] args) throws IOException {
        Image i = new Image();
        i.openImage();
    }
}
