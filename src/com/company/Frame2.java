package com.company;

import javax.swing.*;
import java.io.Serializable;

public class Frame2 extends JFrame{
    private JCheckBox inspecciónEnAduanasCheckBox;
    private JTextField idText;
    private JTextField PesoText;
    private JTextArea DescripcionText;
    private JTextField EmisoraText;
    private JTextField RemitenteText;
    private JTextField PaisText;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JPanel Aduanas;

    private Contenedor c1;
    public Frame2(){
        setTitle("Gestión de contenedores");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(700,400);
        setContentPane(Aduanas);


    }
    public void mostrar(Contenedor c1){
        /*Rellenamos la ventana según los valores de las variables del Contenedor,
        para obtener los valores, como son privados, usamos gets*/
        this.c1=c1;
        idText.setText(String.valueOf(c1.getId()));
        PesoText.setText(String.valueOf(c1.getPeso()));
        DescripcionText.setText(String.valueOf(c1.getDescripcion()));
        EmisoraText.setText(String.valueOf(c1.getEmpresaemisora()));
        RemitenteText.setText(String.valueOf(c1.getEmpresaremitente()));
        PaisText.setText(String.valueOf(c1.getPais()));
        inspecciónEnAduanasCheckBox.setSelected(c1.inspeccionado);
        ButtonGroup grupo=new ButtonGroup();
        if (c1.prioridad==1){
            a1RadioButton.setSelected(true);
        }
        if (c1.prioridad==2){
            a2RadioButton.setSelected(true);
        }
        if (c1.prioridad==3){
            a3RadioButton.setSelected(true);
        }
    }
}
