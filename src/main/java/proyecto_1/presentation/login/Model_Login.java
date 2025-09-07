package proyecto_1.presentation.login;

import proyecto_1.logic.Usuario;
import proyecto_1.presentation.AbstractModel;
import proyecto_1.logic.Medico;

import java.beans.PropertyChangeListener;

public class Model_Login extends AbstractModel{
    Usuario current;

    public static final String CURRENT = "current";

    public Model_Login(){ current = new Usuario() ;}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        //firePropertyChange(CURRENT);
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }
}
