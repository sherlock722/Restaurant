package restaurant.fjc.com.model;

import java.util.ArrayList;

/**
 * Created by javier on 9/5/16.
 */
public class Tables {

    private ArrayList<Table> mTables;

    public Tables() {
        mTables = new ArrayList<Table>();

        //Añadimos unos ejemplos de mesas
        mTables.add(new Table("Mesa1",1));
        mTables.add(new Table("Mesa2",2));
        mTables.add(new Table("Mesa3",3));
        mTables.add(new Table("Mesa4",4));
        mTables.add(new Table("Mesa5",5));
    }
    public ArrayList<Table> getTables() {
        return mTables;
    }

    public void setTables(ArrayList<Table> tables) {
        mTables = tables;
    }

    public void addTable(Table table) {
        mTables.add(table);
    }

    public void setTable(int position, Table table) {
        mTables.set(position, table);
    }
}
