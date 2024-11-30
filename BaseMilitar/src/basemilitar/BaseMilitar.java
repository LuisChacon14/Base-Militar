/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basemilitar;

import Visual.PanelPrincipal;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author usuario
 */
public class BaseMilitar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PanelPrincipal meth = new PanelPrincipal();
        meth.setVisible(true);
        String [] songs = {
            "Sonidos/Cancion1.wav", 
            "Sonidos/Cancion2.wav", 
            "Sonidos/Cancion3.wav"
        };
        
        for (String songPath : songs) {
            playSong(songPath);
        }
    }
        
        public static void playSong(String songPath) {
        try {
            // Cargar el archivo de audio
            File songFile = new File(songPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(songFile);
            
            // Obtener el clip de audio
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            // Reproducir el clip
            clip.start();
            // Esperar a que termine
            while (!clip.isRunning()) Thread.sleep(10);  // Asegurar que inicia
            while (clip.isRunning()) Thread.sleep(10);   // Esperar mientras suena

            // Cerrar recursos
            clip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("El formato del archivo no es compatible: " + songPath);
        } catch (IOException e) {
            System.out.println("Error al reproducir el archivo: " + songPath);
        } catch (LineUnavailableException e) {
            System.out.println("No se puede acceder al dispositivo de audio.");
        } catch (InterruptedException e) {
            System.out.println("Interrumpido mientras se esperaba.");
        }
    }
}

        
    
    

