package proyecto_1.presentation.dashboard;

import proyecto_1.logic.Receta;
import proyecto_1.logic.Service;

import java.util.List;
import java.util.Map;

public class Controller_Dashboard {
    View_Dashboard view;
    Model_Dashboard model;
    public Controller_Dashboard(View_Dashboard view, Model_Dashboard model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
        getAllRecetas();
    }

    //--Buscar Recetas--
    public void getAllRecetas() {
        List<Receta> recetas = Service.getInstance().getListaRecetas();
        model.setAllRecetas(recetas);
    }
    public void filtrarRecetas(String tipo, String texto) {
        List<Receta> result = Service.getInstance().filtrarRecetas(tipo, texto);
        model.setAllRecetas(result);
    }

    public void renderPieEstados() {
        // 2) convierte a conteos
        Map<String, Integer> conteo = model.conteoPorEstado();

        // 3) construye el ChartPanel
        javax.swing.JPanel chartPanel = ChartsFactory.buildPieRecetasPorEstado(conteo);

        // 4) insértalo en el panel de la View
        view.setPieRecetasPanel(chartPanel);
    }
}
