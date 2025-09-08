package proyecto_1.presentation.dashboard;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View_Dashboard implements PropertyChangeListener {
    Controller_Dashboard controller;
    Model_Dashboard model;
    private JPanel panel;
    private JPanel pnlPieEstados;
    private JTable table1;
    private JSpinner spDesdeAnio;
    private JSpinner spHastaAnio;
    private JSpinner cbDesdeMes;
    private JSpinner cbHastaMes;
    private JComboBox cbMedicamento;
    private JButton btnAgregar;
    private JButton btnAgregarTodos;
    private JButton borrarActualButton;
    private JButton borrarTodosButton;

    public void setController(Controller_Dashboard controller) {
        this.controller = controller;
    }
    public void setModel(Model_Dashboard model) {
        this.model = model;
        model.addPropertyChangeListener((PropertyChangeListener) this);
    }


    public JPanel getPanel() {
        return panel;
    }

    // Metodo helper para inyectar el ChartPanel
    public void setPieRecetasPanel(javax.swing.JPanel chartPanel) {
        pnlPieEstados.removeAll();
        pnlPieEstados.setLayout(new BorderLayout());
        pnlPieEstados.add(chartPanel, BorderLayout.CENTER);
        pnlPieEstados.revalidate();
        pnlPieEstados.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model_Dashboard.ALLRECETAS:
                controller.renderPieEstados();
                break;
        }

    }
}
