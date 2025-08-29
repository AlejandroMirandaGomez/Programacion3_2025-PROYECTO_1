package proyecto_1.presentation.prescribir;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Prescribir implements PropertyChangeListener {
    private JPanel panel;
    private JPanel control;
    private JButton buscarPacienteBtn;
    private JButton agregarMedicamentoBtn;
    private DatePicker fechaRetiro;
    private JLabel nombrePaciente;
    private JTable tablaPrescripciones;
    private JPanel ajustar;
    private JButton guardar;
    private JButton limpiar;
    private JButton descartar;
    private JButton detalles;

    Controller_Prescribir controller;
    Model_Prescribir model;

    public View_Prescribir(){

    }

    public JPanel getPanel() {
        return panel;
    }


    public void setController(Controller_Prescribir controller) {
        this.controller = controller;
    }

    public void setModel(Model_Prescribir model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Model_Prescribir.PRESCRIPCIONES)) {
            int[] cols = {TableModel.MEDICAMENTO, TableModel.PRESENTACION, TableModel.INDICACION, TableModel.CANTIDAD, TableModel.DURACION};
            tablaPrescripciones.setModel(new TableModel(cols, model.getPrescripciones()));
        }
    }
}
