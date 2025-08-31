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

    private View_BuscarPaciente buscarPaciente;

    public View_Despacho() {
        buscarPaciente = new View_BuscarPaciente();

        pacienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPaciente.setVisible(true);
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
        this.buscarPaciente.setController(controller);
    }
    public void setModel(Model_Despacho model) {
        this.model = model;
        model.addPropertyChangeListener(this);

        this.buscarPaciente.setModel(model);
        model.addPropertyChangeListener(buscarPaciente);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model_Despacho.RECETAS:
                int[] cols = {TableModel.ID_PACIENTE, TableModel.NOMBRE_PACIENTE, TableModel.FECHA_RETIRO, TableModel.NOMBRE_MEDICO, TableModel.ESTADO};
                tablaListaRecetas.setModel(new TableModel(cols, model.getRecetas()));
                break;
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}

