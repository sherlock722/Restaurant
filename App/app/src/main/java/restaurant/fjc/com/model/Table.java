package restaurant.fjc.com.model;


import java.io.Serializable;
/**
 * Created by javier on 9/5/16.
 */
public class Table implements Serializable{

    private String mName;
    private int mNumPeople;
    //private Menu mOrders;

    /*public Table(String name, int numPeople, Menu orders, Float bill) {
        mName = name;
        mNumPeople = numPeople;
        //mOrders = orders;
    }*/

    public Table(String name, int  numPeople) {
        mName = name;
        mNumPeople = numPeople;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getNumDiners() {
        return mNumPeople;
    }

    public void setNumDiners(int numDiners) {
        mNumPeople = numDiners;
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
