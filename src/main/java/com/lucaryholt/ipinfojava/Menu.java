package com.lucaryholt.ipinfojava;

import java.awt.*;
import java.net.URI;
import java.util.Scanner;

public class Menu {

    IPInfo ipInfoHandler = new IPInfoAPI(); //new JSONHandler();
    IPInfoHolder ipInfoHolder;

    Scanner sc = new Scanner(System.in);

    public void start(){
        ipInfoHolder = ipInfoHandler.getHolder();

        main();
    }

    public void main(){
        System.out.println(
                "IP-Info\n" +
                "IP: " + ipInfoHolder.getIp() + "\n" +
                "Location: " + ipInfoHolder.getPostal() + " " + ipInfoHolder.getCity() + "\n"
        );

        System.out.println(
                "(1) Look up other IP\n" +
                "(2) Open location in Google Maps\n" +
                "(Q) Quit"
        );

        String choice = sc.nextLine();

        switch (choice){
            case "1" :  otherIP();
                        break;
            case "2" :  openMaps();
                        break;
            case "Q" :
            case "q" :  System.exit(1);
        }
    }

    public void otherIP(){
        System.out.println("Enter the IP you want to lookup:");
        String ip = sc.nextLine();

        ipInfoHolder = ipInfoHandler.getHolder(ip);

        main();
    }

    public void openMaps(){
        String link = "http://maps.google.com/?ie=UTF8&hq=&ll=" + ipInfoHolder.getLocation() + "&z=13";

        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(link);
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        main();
    }

}
