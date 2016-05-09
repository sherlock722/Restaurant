package restaurant.fjc.com.model;

import android.view.Menu;

/**
 * Created by javier on 9/5/16.
 */
public class Table {

    private String mName;
    private int mNumDiners;
    //private Menu mOrders;

    public Table(String name, int numDiners, Menu orders, Float bill) {
        mName = name;
        mNumDiners = numDiners;
        //mOrders = orders;
    }

    public Table(String name, int numDiners) {
        mName = name;
        mNumDiners = numDiners;
        //mOrders = new Menu();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getNumDiners() {
        return mNumDiners;
    }

    public void setNumDiners(int numDiners) {
        mNumDiners = numDiners;
    }

    /*public Menu getOrders() {
        return mOrders;
    }*/

    /*public void setOrders(Menu orders) {
        mOrders = orders;
    }*/

    @Override
    public String toString() {
        return getName();
    }
}
