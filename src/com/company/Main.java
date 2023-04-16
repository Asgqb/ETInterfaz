package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        Frame2 ventana2= new Frame2();
        Frame3 ventana3=new Frame3();
        MainFrame ventana =new MainFrame(ventana2,ventana3);

    }
}
