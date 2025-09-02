package proyecto_1.presentation.prescribir;

import com.github.lgooddatepicker.components.DatePicker;
import proyecto_1.presentation.prescribir.buscarMedicamento.View_buscarMedicamento;
import proyecto_1.presentation.prescribir.buscarPaciente.View_BuscarPaciente;
import proyecto_1.presentation.prescribir.guardarMedicamento.View_GuardarMedicamento;

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
    private proyecto_1.presentation.prescribir.guardarMedicamento.View_GuardarMedicamento guardarMedicamentoView;

    Controller_Prescribir controller;
    Model_Prescribir model;



    public View_Prescribir(){
        buscarPacienteView = new  View_BuscarPaciente();
        buscarMedicamentoView = new View_buscarMedicamento();
        guardarMedicamentoView = new View_GuardarMedicamento();

        descartar.setEnabled(false);
        detalles.setEnabled(false);


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
        tablaPrescripciones.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tablaPrescripciones.getSelectedRow();
                if (row >= 0) {
                    descartar.setEnabled(true);
                    detalles.setEnabled(true);
                }

            }
        });

        descartar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tablaPrescripciones.getSelectedRow();
                if (row >= 0) {
                    controller.borrarPrescripcion(row);
                    descartar.setEnabled(false);
                    detalles.setEnabled(false);
                }
            }
        });
        /*
        detalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tablaPrescripciones.getSelectedRow();
                if (row >= 0) {
                    controller.seleccionarPrescripcionDetalle(row);
                    descartar.setEnabled(false);
                    detalles.setEnabled(false);
                }
            }
        });*/
    }

    public JPanel getPanel() {
        return panel;
    }


    public void setController(Controller_Prescribir controller) {
        this.controller = controller;
        buscarPacienteView.setController(controller);
        buscarMedicamentoView.setController(controller);
        guardarMedicamentoView.setController(controller);
    }

    public void setModel(Model_Prescribir model) {
        this.model = model;
        model.addPropertyChangeListener(this);

        buscarMedicamentoView.setModel(model);
        model.addPropertyChangeListener(buscarMedicamentoView);

        buscarPacienteView.setModel(model);
        model.addPropertyChangeListener(buscarPacienteView);

        guardarMedicamentoView.setModel(model);
        model.addPropertyChangeListener(guardarMedicamentoView);


    }
    public void abrirGuardarMedicamento() {
        guardarMedicamentoView.setLocationRelativeTo(panel);
        guardarMedicamentoView.setVisible(true);
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
