/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempowaitnotify;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ExempoWaitNotify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Processor obj = new Processor();
        
        Thread t1;
        t1 = new Thread(new Runnable(){
            public void run(){
                try {
                    obj.producer();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ExempoWaitNotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                try {
                    obj.consumer();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ExempoWaitNotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
    
}
