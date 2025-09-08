package proyecto_1.presentation.dashboard;

import proyecto_1.logic.Receta;
import proyecto_1.presentation.AbstractModel;
import java.util.*;

import static proyecto_1.presentation.dashboard.ChartsFactory.*;

public class Model_Dashboard extends AbstractModel {
    public static final String ALLRECETAS = "AllRecetas";


    List<Receta> AllRecetas;

    public List<Receta> getAllRecetas() { return AllRecetas; }

    public void setAllRecetas(List<Receta> recetas) {
        this.AllRecetas = recetas;
        firePropertyChange(ALLRECETAS);
    }

    // Devuelve un mapa con los conteos por estado en ORDEN fijo
    public Map<String, Integer> conteoPorEstado() {
        Map<String, Integer> m = new LinkedHashMap<>();
        m.put(EN_PROCESO, 0);
        m.put(LISTA, 0);
        m.put(ENTREGADA, 0);
        m.put(CONFECCIONADA, 0);

        if (AllRecetas == null) return m;
        for (Receta r : AllRecetas) {
            String e = r.getEstado();
            m.put(e, m.get(e) + 1);
        }

        return m;
    }

    //AllRecetas.onChange()
}
