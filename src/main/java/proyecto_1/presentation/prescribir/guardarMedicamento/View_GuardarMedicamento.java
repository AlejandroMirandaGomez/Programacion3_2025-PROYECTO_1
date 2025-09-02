package proyecto_1.presentation.prescribir.guardarMedicamento;

import proyecto_1.logic.Medicamento;
import proyecto_1.logic.Prescripcion;
import proyecto_1.presentation.prescribir.Controller_Prescribir;
import proyecto_1.presentation.prescribir.Model_Prescribir;
import proyecto_1.presentation.prescribir.buscarPaciente.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_GuardarMedicamento extends JDialog  implements PropertyChangeListener {
    private JPanel contentPane;
    private JSpinner cantidad;
    private JSpinner duracion;
    private JTextArea instrucciones;
    private JButton guardar;
    private JButton cancelar;
    private JButton buttonOK;



    private Model_Prescribir model;
    private Controller_Prescribir controller;

    public View_GuardarMedicamento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setLocationRelativeTo(null);
        setTitle("Detalles medicamento");
        setSize(400, 250);


        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar()) {

                    Prescripcion n = take();

                    try {

                        controller.crearPrescripcion(n);


                        JOptionPane.showMessageDialog(null, "REGISTRO APLICADO", "", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    dispose();
                }
            }
        });

        cancelar.addActionListener(e -> dispose());

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
        switch (evt.getPropertyName()) {
            case Model_Prescribir.CURRENTDETALLE:
                    cantidad.setValue(model.getCurrentDetalle().getCantidad());
                    duracion.setValue(model.getCurrentDetalle().getDuracion());
                    instrucciones.setText(model.getCurrentDetalle().getIndicaciones());
                break;

        }
    }


    public Prescripcion take(){
        Prescripcion prescripcion = new Prescripcion();
        prescripcion.setMedicamento(model.getCurrentDetalle().getMedicamento());
        prescripcion.setCantidad((Integer)cantidad.getValue());
        prescripcion.setDuracion((Integer)duracion.getValue());
        prescripcion.setIndicaciones((String)instrucciones.getText());
        return prescripcion;
    }

    private boolean validar() {
        boolean valid = true;
        if ((Integer)cantidad.getValue()==0) {
            valid = false;
            cantidad.setBackground(Color.RED);
            cantidad.setToolTipText("cantidad requerida");
        } else {
            cantidad.setBackground(null);
            cantidad.setToolTipText(null);
        }
        if ((Integer)duracion.getValue()==0) {
            valid = false;
            duracion.setBackground(Color.RED);
            duracion.setToolTipText("cantidad requerida");
        } else {
            duracion.setBackground(null);
            duracion.setToolTipText(null);
        }
        if (instrucciones.getText().isEmpty()) {
            valid = false;
            instrucciones.setBackground(Color.RED);
            instrucciones.setToolTipText("cantidad requerida");
        } else {
            instrucciones.setBackground(null);
            instrucciones.setToolTipText(null);
        }

        return valid;
    }
}
