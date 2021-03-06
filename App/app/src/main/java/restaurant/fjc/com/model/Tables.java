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
        mTables.add(new Table("Mesa_1",2));
        mTables.add(new Table("Mesa_2",2));
        mTables.add(new Table("Mesa_3",2));
        mTables.add(new Table("Mesa_4",3));
        mTables.add(new Table("Mesa_5",4));
        mTables.add(new Table("Mesa_6",5));
        mTables.add(new Table("Mesa_7",2));
        mTables.add(new Table("Mesa_8",3));
        mTables.add(new Table("Mesa_9",3));
        mTables.add(new Table("Mesa_10",4));
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
