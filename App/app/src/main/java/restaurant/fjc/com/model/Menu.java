package restaurant.fjc.com.model;

import java.util.ArrayList;

/**
 * Created by javier on 11/5/16.
 */
public class Menu {
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

    public void setDishes(ArrayList<MenuContent> menuContents) {
        mMenuContents = menuContents;
    }

    public void addMenuContent(MenuContent menuContent) {
        mMenuContents.add(menuContent);
    }

    public float getTotal() {
        float total = 0;

        for (MenuContent menuContent:this.getMenuContents()) {
            total += menuContent.getPrice();
        }
        return total;
    }
}
