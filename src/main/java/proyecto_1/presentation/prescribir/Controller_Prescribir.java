package proyecto_1.presentation.prescribir;

import proyecto_1.presentation.prescribir.Model_Prescribir;
import proyecto_1.presentation.prescribir.View_Prescribir;

import java.io.IOException;

public class Controller_Prescribir {
    Model_Prescribir model;
    View_Prescribir view;

    public Controller_Prescribir(View_Prescribir view, Model_Prescribir model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);

    }
}
