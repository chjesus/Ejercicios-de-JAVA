
package interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InterfaceGrafica {
    
    JPanel panel,panel2,panel3;
    JLabel label1,label2,label3,label4,label5,lbalF;
    JTextField text,text2;
    JTextArea text3;
    ButtonGroup grupo;
    JRadioButton radio1,radio2;
    JComboBox combo;
    JScrollPane scroll;
    JButton button,button2;

    
    public void Ventana() throws IOException{
        BufferedWriter crear = new BufferedWriter(new FileWriter("datos.txt"));
        final PrintWriter b = new PrintWriter(crear);
        
        JFrame frame = new JFrame("Acceso al Sistema");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel,BorderLayout.CENTER);
        GridBagConstraints grid = new GridBagConstraints();
        
        label1 = new JLabel("Usuario:");
        grid.gridx=0;
        grid.gridy=0;
        grid.insets = new Insets(10,10,10,10);
        panel.add(label1,grid);
        
        label2 = new JLabel("Email:");
        grid.gridx=0;
        grid.gridy=1;
        panel.add(label2,grid);
        
        label3 = new JLabel("Sexo:");
        grid.gridx=0;
        grid.gridy=2;
        panel.add(label3,grid);
        
        label4 = new JLabel("Carrera:");
        grid.gridx=0;
        grid.gridy=3;
        panel.add(label4,grid);
        
        label5 = new JLabel("Comentario:");
        grid.gridx=0;
        grid.gridy=4;
        panel.add(label5,grid);
       
        text = new JTextField("",20);
        grid.gridx=1;
        grid.gridy=0;
        text.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                if(text.getText().length()>=10){
                     e.consume();
                }
            }
        });
        panel.add(text,grid);
        
        text2 = new JTextField("",20);
        grid.gridx=1;
        grid.gridy=1;
        panel.add(text2,grid);
        
        grupo = new ButtonGroup();
        radio1 = new JRadioButton("M",false);
        radio2 = new JRadioButton("F",false);
        grupo.add(radio1);
        grupo.add(radio2);
        grid.gridx=1;
        grid.gridy=2;
        panel.add(radio1,grid);
        grid.gridx=2;
        grid.gridy=2;
        panel.add(radio2,grid);
        
        combo = new JComboBox();
        combo.addItem("Ing. Informatica");
        combo.addItem("Ing. Civil");
        combo.addItem("Ing. Mecanica");
        combo.addItem("Ing. Electronica");
        grid.gridx=1;
        grid.gridy=3;
        panel.add(combo,grid);
        
        text3 = new JTextArea("",5,20);
        scroll = new JScrollPane(text3);
        grid.gridx=1;
        grid.gridy=4;
        text3.setLineWrap(true);
        panel.add(scroll,grid);
        
        panel2 = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel2,BorderLayout.SOUTH);
        
        button = new JButton("Guardar");
        grid.gridx=1;
        grid.gridy=0;
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                b.write(text.getText());
                b.println();
                b.write(text2.getText());
                b.println();
                b.write(text3.getText());
                b.println();
                b.close();
                
                JOptionPane.showMessageDialog(null, "Informacion Guardada!");
            }
            
        });
        panel2.add(button,grid);
        button2 = new JButton("Cancelar");
        grid.gridx=2;
        grid.gridy=0;
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(" ");
                text2.setText(" ");
                text3.setText(" ");
                
            }
            
        });
        panel2.add(button2,grid);
        
        panel3 = new JPanel(new FlowLayout());
        lbalF = new JLabel("Ingresar Informacion!");
        panel3.add(lbalF);
        frame.getContentPane().add(panel3,BorderLayout.NORTH);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        InterfaceGrafica in = new InterfaceGrafica();
        in.Ventana();
    }
    
}
