package proyecto_1.presentation.despacho;

public class Controller_Despacho {
    View_Despacho view;
    Model_Despacho model;

    public Controller_Despacho(View_Despacho view, Model_Despacho model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
