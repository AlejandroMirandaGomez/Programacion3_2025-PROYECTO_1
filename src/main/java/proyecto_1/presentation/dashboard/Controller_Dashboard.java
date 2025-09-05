package proyecto_1.presentation.dashboard;

public class Controller_Dashboard {
    View_Dashboard view;
    Model_Dashboard model;
    public Controller_Dashboard(View_Dashboard view, Model_Dashboard model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
}
