package proyecto_1.presentation.login;

import proyecto_1.logic.Medico;
import proyecto_1.logic.Service;
import proyecto_1.logic.Sesion;
import proyecto_1.logic.Usuario;

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


    public void login(Usuario usuario) throws Exception{
        Usuario logged = Service.getInstance().read(usuario);
        if(!logged.getPassword().equals(usuario.getPassword())){
            throw new Exception("Usuario o clave incorrectos");
        }
        Sesion.setUsuario(logged);
    }

    public void changePassword(Usuario usuario, String newPassword)throws  Exception{
        Usuario logged = Service.getInstance().read(usuario);
        if(logged.getPassword().equals(usuario.getPassword())){
            //logged.setPassword(newPassword);
            logged.setPassword(newPassword);
            Service.getInstance().update(logged);
        }
    }
}
