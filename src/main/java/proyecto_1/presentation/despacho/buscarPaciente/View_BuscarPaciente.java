package proyecto_1.presentation.despacho.buscarPaciente;

import javax.swing.*;

public class View_BuscarPaciente extends JDialog {
    private JPanel panel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel panelFiltros;
    private JPanel panelListaPacientes;
    private JPanel panelBarraBotones;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTable table1;

    public View_BuscarPaciente() {
        setContentPane(panel);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }
    public JPanel getPanel() {return panel;}
}
