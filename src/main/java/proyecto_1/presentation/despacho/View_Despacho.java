package proyecto_1.presentation.despacho;

import proyecto_1.presentation.despacho.buscarPaciente.View_BuscarPaciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Despacho implements PropertyChangeListener {
    Controller_Despacho controller;
    Model_Despacho model;
    private JPanel panel;
    private JTextField buscarPorPacienteEstevanTextField;
    private JTable tablaListaRecetas;
    private JRadioButton verTodoRadioBtn;
    private JPanel buscarPor;
    private JButton pacienteBtn;
    private JButton estadoBtn;
    private JButton limpiarBtn;

    public View_Despacho() {
        pacienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_BuscarPaciente buscarPaciente = new View_BuscarPaciente();

                // Crear un JDialog para mostrarlo
                JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(panel), "Buscar Paciente", true);
                dialog.setContentPane(buscarPaciente.getPanel()); // el panel principal de BuscarPaciente
                dialog.pack();  // ajusta el tamaño al contenido
                dialog.setLocationRelativeTo(panel); // centra respecto a la ventana actual
                dialog.setVisible(true); // muestra el diálogo
            }
        });
        verTodoRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verTodoRadioBtn.isSelected()) {
                    controller.getRecetas();
                } else{
                    controller.limpiarRecetas();
                }
            }
        });
    }

    public void setController(Controller_Despacho controller) {
        this.controller = controller;
    }
    public void setModel(Model_Despacho model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model_Despacho.LIST:
                int[] cols = {TableModel.ID_PACIENTE, TableModel.NOMBRE_PACIENTE, TableModel.FECHA_RETIRO, TableModel.NOMBRE_MEDICO, TableModel.ESTADO};
                tablaListaRecetas.setModel(new TableModel(cols, model.getRecetas()));
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}

