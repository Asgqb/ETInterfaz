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
        mostrarDatosContenedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana2.setVisible(true);
            }
        });
    }
    private JTextField textField4;
    private JTextField textField5;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JRadioButton a1RadioButton;
    private JCheckBox inspecciónEnAduanasCheckBox;
    private JTextArea Estado;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JTabbedPane tabbedPane1;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton mostrarDatosContenedorButton;
    private JButton cuantosButton;
    private JTextField númeroDeColumnaTextField;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JPanel panel;
}

