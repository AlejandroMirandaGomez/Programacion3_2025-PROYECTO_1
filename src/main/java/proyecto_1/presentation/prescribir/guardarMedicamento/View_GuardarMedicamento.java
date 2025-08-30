package proyecto_1.presentation.prescribir.guardarMedicamento;

import javax.swing.*;

public class View_GuardarMedicamento extends JDialog {
    private JPanel contentPane;
    private JSpinner cantidad;
    private JSpinner duracion;
    private JTextArea instrucciones;
    private JButton guardar;
    private JButton cancelar;
    private JButton buttonOK;

    public View_GuardarMedicamento() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }
}
