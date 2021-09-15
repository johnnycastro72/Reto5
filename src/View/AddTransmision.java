/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Access.transmisionDAO;
import Controller.ClickEvent;
import Controller.InitialData;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Model.transmisionModel;
import Model.usuarioModel;
import Model.contenidoModel;

/**
 *
 * @author JCC
 */
public class AddTransmision extends JFrame implements ActionListener {
    private JLabel                     lblId;
    private JTextField                 txtId;
    private JLabel                     lblUsuario;
    private JComboBox<usuarioModel>    cbxUsuario;
    private JLabel                     lblContenido;
    private JComboBox<contenidoModel>  cbxContenido;
    private JLabel                     lblFecha;
    private JTextField                 txtFecha;
    private JButton                    btnInsertTransmision;
    
    public AddTransmision(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("4ChanVideo - Agregar Transmisión");
        setLayout(new GridLayout(8,2));
        InitialData initialData = new InitialData();
        this.setLocationRelativeTo(null);
        
        this.lblUsuario = new JLabel("Seleccione usuario:");
        add(this.lblUsuario);
        this.cbxUsuario = new JComboBox();
        this.cbxUsuario.setModel(new DefaultComboBoxModel<>(initialData.getUsuarios().toArray(new usuarioModel[initialData.getUsuarios().size()])));
        this.cbxUsuario.setSelectedIndex(0);
        add(this.cbxUsuario);
               
        this.lblContenido = new JLabel("Seleccione contenido:");
        add(this.lblContenido);
        this.cbxContenido = new JComboBox<>();
        this.cbxContenido.setModel(new DefaultComboBoxModel<>(initialData.getContenidos().toArray(new contenidoModel[initialData.getContenidos().size()])));
        this.cbxContenido.setSelectedIndex(0);
        add(this.cbxContenido);
        
        this.lblFecha = new JLabel("Escriba la fecha y hora");
        add(this.lblFecha);
        this.txtFecha = new JTextField();
        add(this.txtFecha);
        
        this.btnInsertTransmision = new JButton("Agregar a BD");
        add(this.btnInsertTransmision);
        
        this.btnInsertTransmision.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertTransmision) {
            String idAliasFK     = ((usuarioModel)this.cbxUsuario.getSelectedItem()).getUsu_alias();
            int    idContenidoFK = ((contenidoModel)this.cbxContenido.getSelectedItem()).getCon_id();
            String fechahora     = this.txtFecha.getText();
            
            transmisionModel transmision = new transmisionModel(idAliasFK, idContenidoFK, fechahora);
            
            transmisionDAO oTransmisionDAO = new transmisionDAO();
            oTransmisionDAO.insertTransmision(transmision);
            dispose();
        }
    }
    
}
