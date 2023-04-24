package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class MainFrame extends JFrame implements Serializable{
    public MainFrame(Frame2 ventana2,Frame3 ventana3){
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
        p1=Puerto.cargarPuerto();  //p1 es un atributo de la ventana, si hay un puerto guardado lo cargamos
        comboBox2.setModel(comboBox1.getModel()); //Copio opciones del primer combobox


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
                Puerto.guardarPuerto(p1); //Guardamos el puerto después de apilar el contenedor


            }
        });

        mostrarDatosContenedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*Vamos pasando por las distintas filas y columnas de los tres hubs,
                si una casilla no está vacía cogemos el contenedor y su id, si el id es igual al
                que buscamos, salimos del bucle, y llamamos al metodo mostrar de Frame2 y abrimos
                la segunda ventana. En caso de que no sean iguales, seguimos cogiendo
                contenedores y sus id y comparamos estos ultimos con el id introducido por texto
                 */
                Contenedor c1=null;
                int id = Integer.parseInt(mostrardatostext.getText());
                int id2=0;
                for (int i = 0; i < 3; i++) {
                    for (int x = 0; x < 10; x++) {
                        for (int y = 0; y < 12; y++) {
                            if (i==0)
                            {
                                if(p1.puerto[0].vacio(x,y)==true){continue;}
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

        /*
        Vamos pasando por las diferentes filas y columnas de los hubs, y comparamos sus id (si no están vacias)
        con el que buscamos, si es igual procedemos a desapilar el contenedor del puerto y salir del bucle,
        sino, seguimos.
         */
        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(DesapilarText.getText());
                int id2=0;
                for (int i = 0; i < 3; i++) {
                    for (int x = 0; x < 10; x++) {
                        for (int y = 0; y < 12; y++) {
                            if (i==0)
                            {
                                if(p1.puerto[0].vacio(x,y)==true){continue;}
                                id2=p1.puerto[0].getid(x,y); if (id2==id){p1.puerto[0].desapilar(y+1);break;}
                            }
                            else if (i==1)
                            {
                                if(p1.puerto[1].vacio(x,y)==true){continue;}
                                id2=p1.puerto[1].getid(x,y);if (id2==id){p1.puerto[1].desapilar(y+1);break;}
                            }
                            else if (i==2){
                                if(p1.puerto[2].vacio(x,y)==true){continue;}
                                id2=p1.puerto[2].getid(x,y);if (id2==id){p1.puerto[2].desapilar(y+1);break;}
                            }

                        }
                    }
                }
                Puerto.guardarPuerto(p1);
                //guardamos el puerto una vez desapilado el contenedor
            }
        });
        /*Seguimos buscando en el puerto, en este caso no son ids, sino el pais de procedencia
        , si los encontramos sumamos 1 a un contador que luego mostramos en una casilla de texto*/
        cuantosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pais=(String)comboBox2.getSelectedItem();
                String pais2;
                int contador=0;
                for(int i=0;i<3;i++){
                    for(int x=0;x<10;x++){
                        for(int y=0;y<12;y++){
                            if(p1.puerto[i].vacio(x,y)==true){continue;}
                            pais2=p1.puerto[i].pais(x,y);
                            if(pais2==pais) contador=contador+1;
                        }
                    }
                }
                textField3.setText(String.valueOf(contador));

            }
        });
        /*Llama al metodo mostrar 3 veces y lo almacena en una variable que luego es pasada a un metodo
        de la tercera ventana para que sea mostrado*/
        MostrarEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto=null;
                for (int i=0;i<3;i++){
                    if (i==0)texto=p1.puerto[0].mostrar();
                    else texto=texto+p1.puerto[i].mostrar();
                }
                ventana3.mostrarEstado(texto);
                ventana3.setVisible(true);
            }
        });
    }
    private JTextField textField4;
    private JTextField textField5;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JCheckBox inspecciónEnAduanasCheckBox;
    private ButtonGroup ButtonGroup2=new ButtonGroup();  //Creamos grupo de botones para que sean excluyentes
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JTabbedPane tabbedPane1;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton mostrarDatosContenedorButton;
    private JButton cuantosButton;
    private JTextField DesapilarText;
    private JComboBox comboBox2;
    private JTextField textField3;
    private JPanel panel;
    private JTextField textField;
    private javax.swing.JTextField textField2;
    private JLabel emisora;
    private JLabel remitente;
    private JTextField mostrardatostext;
    private JButton MostrarEstado;
    private Puerto p1;
}

