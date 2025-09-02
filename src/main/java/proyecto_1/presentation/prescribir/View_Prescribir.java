package proyecto_1.presentation.prescribir;

import com.github.lgooddatepicker.components.DatePicker;
import proyecto_1.presentation.prescribir.buscarMedicamento.View_buscarMedicamento;
import proyecto_1.presentation.prescribir.buscarPaciente.View_BuscarPaciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private proyecto_1.presentation.prescribir.buscarPaciente.View_BuscarPaciente buscarPacienteView;
    private proyecto_1.presentation.prescribir.buscarMedicamento.View_buscarMedicamento buscarMedicamentoView;

    Controller_Prescribir controller;
    Model_Prescribir model;

    public View_Prescribir(){
        buscarPacienteView = new  View_BuscarPaciente();
        buscarMedicamentoView = new View_buscarMedicamento();



        buscarPacienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarPacienteView.setVisible(true);
            }
        });
        agregarMedicamentoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarMedicamentoView.setVisible(true);
            }
        });

        tablaPrescripciones.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public JPanel getPanel() {
        return panel;
    }


    public void setController(Controller_Prescribir controller) {
        this.controller = controller;
        buscarPacienteView.setController(controller);
    }

    public void setModel(Model_Prescribir model) {
        this.model = model;
        model.addPropertyChangeListener(this);

        buscarPacienteView.setModel(model);
        model.addPropertyChangeListener(buscarPacienteView);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model_Prescribir.PRESCRIPCIONES:
                int[] cols = {TableModel.MEDICAMENTO, TableModel.PRESENTACION, TableModel.INDICACION, TableModel.CANTIDAD, TableModel.DURACION};
                tablaPrescripciones.setModel(new TableModel(cols, model.getPrescripciones()));
                break;
            case Model_Prescribir.CURRENT:
                if (model.getCurrentReceta().getPaciente() == null) {
                    nombrePaciente.setText("No hay paciente");
                }else{
                    nombrePaciente.setText(model.getCurrentReceta().getPaciente().getNombre());
                }


        }

    }
}
