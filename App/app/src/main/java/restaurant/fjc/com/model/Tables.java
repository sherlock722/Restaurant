package restaurant.fjc.com.model;

import java.util.ArrayList;

/**
 * Created by javier on 9/5/16.
 */
public class Tables {

    private ArrayList<Table> mTables;

    public Tables() {
        mTables = new ArrayList<Table>();
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
