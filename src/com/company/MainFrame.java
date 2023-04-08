package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    public MainFrame(Frame2 ventana2){
        setTitle("Gestión de contenedores");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        setContentPane(panel);
        ButtonGroup2.add(a1RadioButton);   //Añadimos los botones al grupo de botones que hemos
        ButtonGroup2.add(a2RadioButton);    //creado fuera del constructor para que sean excluyentes
        ButtonGroup2.add(a3RadioButton);
        //Añadir opciones a la selección de países
        comboBox1.addItem("España");
        comboBox1.addItem("Italia");
        comboBox1.addItem("Francia");
        Puerto p1=new Puerto();  //Creamos puerto

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Primero creamos variables que cojan los valores introducidos
                int id=Integer.parseInt(textField.getText());
                int peso=Integer.parseInt(textField2.getText());
                String pais= (String)comboBox1.getSelectedItem();
                boolean inspeccionado=inspecciónEnAduanasCheckBox.isSelected();
                int prioridad=0;
                if (a1RadioButton.isSelected()){prioridad=1;}
                else if (a2RadioButton.isSelected()){prioridad=2;}
                else if (a3RadioButton.isSelected()){prioridad=3;}
                String descripción=textArea1.getText();
                String empresaemisora=textField4.getText();
                String empresaremitente=textField5.getText();


                //Luego creamos un contenedor con esas variables, y lo apilamos en el puerto
                Contenedor c1 = new Contenedor(id,peso,pais,inspeccionado,prioridad,descripción,empresaemisora,empresaremitente);
                p1.apilarPuerto(c1);

            }
        });

        mostrarDatosContenedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Contenedor c1=null;
                int id = Integer.parseInt(mostrardatostext.getText());
                int id2=0;
                for (int i = 0; i < 3; i++) {
                    for (int x = 0; x < 10; x++) {
                        for (int y = 0; y < 12; y++) {
                            if (i==0)
                            {
                                if(p1.puerto[0].vacio(x,y)==true){
                                    System.out.println(y);
                                    System.out.println(p1.puerto[0].mostrar());;continue;}
                                id2=p1.puerto[0].getid(x,y);c1=p1.puerto[0].getContenedor(x,y);
                            }
                            else if (i==1)
                            {
                                if(p1.puerto[1].vacio(x,y)==true){continue;}
                                id2=p1.puerto[1].getid(x,y);c1=p1.puerto[1].getContenedor(x,y);
                            }
                            else if (i==2){
                                if(p1.puerto[2].vacio(x,y)==true){continue;}
                                id2=p1.puerto[2].getid(x,y);c1=p1.puerto[2].getContenedor(x,y);
                            }
                            if (id2==id) {break;}
                        }
                    }
                }
                if (c1!=null) {
                    ventana2.mostrar(c1);
                    ventana2.setVisible(true);
                }
                else{
                    ventana2.setVisible(true);
                }







            }
        });
    }
    private JTextField textField4;
    private JTextField textField5;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JCheckBox inspecciónEnAduanasCheckBox;
    private JTextArea Estado;
    private ButtonGroup ButtonGroup2=new ButtonGroup();  //Creamos grupo de botones para que sean excluyentes
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JTabbedPane tabbedPane1;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton mostrarDatosContenedorButton;
    private JButton cuantosButton;
    private JTextField númeroDeColumnaTextField;
    private JComboBox comboBox2;
    private JTextField textField3;
    private JPanel panel;
    private JTextField textField;
    private javax.swing.JTextField textField2;
    private JLabel emisora;
    private JLabel remitente;
    private JTextField mostrardatostext;
}

