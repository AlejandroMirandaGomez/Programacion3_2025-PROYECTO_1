package main.java.proyecto_1.presentation.login;

import main.java.proyecto_1.logic.Medico;
import main.java.proyecto_1.logic.Service;

import javax.naming.ldap.Control;


public class Controller_Login {
    View_Login view;
    Model_Login model;

    public Controller_Login(View_Login view, Model_Login model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void readLogin(String id, String Password) throws Exception {
        Medico medico = new Medico();
        medico.setId(id);
        medico.setPassword(Password);
        model.setCurrentMedico(Service.getInstance().read(medico));
    }
}
