package restaurant.fjc.com.model;


import java.io.Serializable;
/**
 * Created by javier on 9/5/16.
 */
public class Table implements Serializable{

    private String mName;
    private int mNumPeople;
    private Menu mMenu;

    public Table(String name, int numPeople, Menu menu) {
        mName = name;
        mNumPeople = numPeople;
        mMenu = menu;
    }

    public Table(String name, int  numPeople) {
        mName = name;
        mNumPeople = numPeople;
        mMenu = new Menu();
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

    public Menu getMenu() {
        return mMenu;
    }

    public void setMenu(Menu menu) {
        mMenu = menu;
    }

    @Override
    //Se sobreescribe el método para recuperar el nombre de la mesa
    //que es lo que se muestra en la lista (vista) de Mesas
    public String toString() {
        return getName();
    }

}
