package proyecto_1.presentation.prescribir.buscarPaciente;

import proyecto_1.logic.Paciente;
import proyecto_1.logic.Receta;
import proyecto_1.presentation.prescribir.Controller_Prescribir;
import proyecto_1.presentation.prescribir.Model_Prescribir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_BuscarPaciente extends JDialog  implements PropertyChangeListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField busqueda;
    private JTable tablaPacientes;
    private JComboBox tipo;

    private Model_Prescribir model;
    private Controller_Prescribir controller;

    public View_BuscarPaciente() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }
    public void setController(Controller_Prescribir controller) {
        this.controller = controller;
    }

    public void setModel(Model_Prescribir model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public View_BuscarPaciente(JFrame parent, Model_Prescribir model, Controller_Prescribir controller)  {
        super(parent, true);

        setController(controller);
        setModel(model);

        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);


        busqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto=busqueda.getText();
                if (texto.isEmpty()) {
                    controller.getPacientes();
                }else{
                    String tipoElegido = tipo.getSelectedItem().toString();
                    controller.filtrarPacientes(tipoElegido, texto);
                }

            }
        });

        tablaPacientes.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPacientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tablaPacientes.getSelectedRow();
                if (row >= 0) {
                    Paciente p = model.getPacientes().get(row);
                    Receta r = new Receta();
                    r.setPaciente(p);
                    model.setCurrentReceta(r);
                }
                //dispose();//Con solo tocar la fila, sale de la ventana y marca el nombre
            }
        });

        buttonOK.addActionListener(e -> {
            int row = tablaPacientes.getSelectedRow();
            if (row >= 0) {
                Paciente p = model.getPacientes().get(row);
                Receta r = new Receta();
                r.setPaciente(p);
                model.setCurrentReceta(r);
            }
            dispose();
        });

        buttonCancel.addActionListener(e -> dispose());



    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model_Prescribir.PACIENTES:
                int[] cols = {TableModel.ID, TableModel.NOMBRE, TableModel.TELEFONO, TableModel.FECHANACIMIENTO};
                tablaPacientes.setModel(new TableModel(cols, model.getPacientes()));
                break;

        }
    }
}
