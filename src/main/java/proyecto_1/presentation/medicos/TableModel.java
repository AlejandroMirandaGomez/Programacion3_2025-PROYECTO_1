package proyecto_1.presentation.medicos;

import proyecto_1.logic.Medico;
import proyecto_1.presentation.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel<Medico> implements javax.swing.table.TableModel{
    public TableModel(int[] cols, List<Medico> rows){super(cols,rows);}

    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int ESPECIALIDAD = 2;

    @Override
    protected void initColNames(){
        colNames = new String[3];
        colNames[0] = "ID";
        colNames[1] = "NOMBRE";
        colNames[2] = "ESPECIALIDAD";
    }

    @Override
    protected Object getPropetyAt(Medico e, int col){
        switch(cols[col]){
            case ID:
                return  e.getId();
            case  NOMBRE:
                return  e.getNombre();
            case ESPECIALIDAD:
                return  e.getEspecialidad();
            default:
                return "";
        }
    }


}
