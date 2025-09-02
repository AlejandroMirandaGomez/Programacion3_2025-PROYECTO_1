package proyecto_1.presentation.farmaceutas;

import proyecto_1.logic.Farmaceuta;
import proyecto_1.logic.Paciente;
import proyecto_1.presentation.AbstractTableModel;

import java.util.List;

public class TableModel extends AbstractTableModel<Farmaceuta> implements javax.swing.table.TableModel{
    public TableModel(int[] cols, List<Farmaceuta> rows){super(cols,rows);}

    public static final int ID = 0;
    public static final int NOMBRE = 1;

    @Override
    protected void initColNames(){
        colNames = new String[3];
        colNames[0] = "ID";
        colNames[1] = "NOMBRE";
    }

    @Override
    protected Object getPropetyAt(Farmaceuta e, int col){
        switch(cols[col]){
            case ID:
                return  e.getId();
            case  NOMBRE:
                return  e.getNombre();
            default:
                return "";
        }
    }


}
