package proyecto_1.presentation.prescribir.buscarMedicamento;

import proyecto_1.logic.Medicamento;
import proyecto_1.logic.Paciente;
import proyecto_1.logic.Receta;
import proyecto_1.presentation.prescribir.Controller_Prescribir;
import proyecto_1.presentation.prescribir.Model_Prescribir;
import proyecto_1.presentation.prescribir.buscarMedicamento.TableModel;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_buscarMedicamento extends JDialog implements PropertyChangeListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox tipo;
    private JTextField busqueda;
    private JTable tablaMedicamentos;

    private Model_Prescribir model;
    private Controller_Prescribir controller;

    public void setController(Controller_Prescribir controller) {
        this.controller = controller;
    }

    public View_buscarMedicamento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        setLocationRelativeTo(null);
        setTitle("Buscar medicamentos");
        setSize(400, 250);


        busqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto=busqueda.getText();
                if (texto.isEmpty()) {
                    controller.getMedicamentos();
                }else{
                    String tipoElegido = tipo.getSelectedItem().toString();
                    controller.filtrarMedicamentos(tipoElegido, texto);
                }

            }
        });

        tablaMedicamentos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        buttonOK.addActionListener(e -> {
            int row = tablaMedicamentos.getSelectedRow();
            if (row >= 0) {
                Medicamento medicamento = model.getMedicamentos().get(row);

            }
            dispose();
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


    }

    public void setModel(Model_Prescribir model) {
        this.model = model;
        model.addPropertyChangeListener(this);


    }

    private void onCancel() {
        dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model_Prescribir.MEDICAMENTOS:
                int[] cols = {TableModel.CODIGO, TableModel.NOMBRE, TableModel.PRESENTACION};
                tablaMedicamentos.setModel(new TableModel(cols, model.getMedicamentos()));
                break;
        }
    }
}
