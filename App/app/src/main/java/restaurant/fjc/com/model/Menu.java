package restaurant.fjc.com.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by javier on 11/5/16.
 */
public class Menu implements Serializable {

    private ArrayList<MenuContent> mMenuContents;


    public Menu() {
        mMenuContents = new ArrayList<MenuContent>();
    }

    public Menu(ArrayList<MenuContent> menuContents) {
        mMenuContents = menuContents;
    }

    public ArrayList<MenuContent> getMenuContents() {
        return mMenuContents;
    }

    public void setMenuContents(ArrayList<MenuContent> menuContents) {
        mMenuContents = menuContents;
    }
    
    public void addMenuContent(MenuContent menuContent) {

        mMenuContents.add(menuContent);
    }

}
