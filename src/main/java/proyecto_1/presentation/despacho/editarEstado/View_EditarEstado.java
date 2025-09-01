package proyecto_1.presentation.despacho.editarEstado;

import proyecto_1.presentation.despacho.Controller_Despacho;
import proyecto_1.presentation.despacho.Model_Despacho;

import javax.swing.*;
import java.awt.event.*;

public class View_EditarEstado extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public View_EditarEstado() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);
        setTitle("Editar Estodo de Receta");
        setSize(600,400);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    // MVC:

    private Model_Despacho model;
    private Controller_Despacho controller;

    public void setController(Controller_Despacho controller) {
        this.controller = controller;
    }

    public void setModel(Model_Despacho model) {
        this.model = model;
        //model.addPropertyChangeListener(this);
    }
}


