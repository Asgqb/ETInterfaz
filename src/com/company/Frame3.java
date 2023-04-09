package com.company;

import javax.swing.*;

public class Frame3 extends JFrame {


    private JPanel Panel2;
    private JTextArea textArea1;
    private JTextField textField1;

    public Frame3(){
        setTitle("Estado");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(400,600);
        setContentPane(Panel2);


    }
    //Rellena la ventana con el String que hemos pasado como parametro
    public void mostrarEstado(String mostrar){
        textArea1.setText(mostrar);
    }
}