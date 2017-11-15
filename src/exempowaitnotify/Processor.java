/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempowaitnotify;

import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Processor {
    
    public void producer() throws InterruptedException{
        synchronized (this){
            System.out.println("Producing thread running...");
            wait();
            System.out.println("Resumed producer...");
        }
    }
    
    public void consumer() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Waiting for return key...");
            scan.nextLine();
            System.out.println("Return key pressed");
            notify();
            Thread.sleep(3000);
        }
        System.out.println("Threads finished.");
    }
}
