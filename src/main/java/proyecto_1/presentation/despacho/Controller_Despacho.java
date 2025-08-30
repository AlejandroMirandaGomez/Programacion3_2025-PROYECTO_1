package proyecto_1.presentation.despacho;

import proyecto_1.logic.Receta;
import proyecto_1.logic.Service;

import java.util.ArrayList;
import java.util.List;

public class Controller_Despacho {
    View_Despacho view;
    Model_Despacho model;

    public Controller_Despacho(View_Despacho view, Model_Despacho model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    //--Buscar Recetas--
    public void getRecetas() {
        List<Receta> recetas = Service.getInstance().getListaRecetas();
        model.setRecetas(recetas);
    }
    public void filtrarRecetas(String tipo, String texto) {
        List<Receta> result = Service.getInstance().filtrarRecetas(tipo, texto);
        model.setRecetas(result);
    }
    public void limpiarRecetas() {
        List<Receta> recetas = new ArrayList<Receta>();
        model.setRecetas(recetas);
    }
}
