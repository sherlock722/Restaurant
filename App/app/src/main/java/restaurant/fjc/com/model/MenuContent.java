package restaurant.fjc.com.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by javier on 11/5/16.
 */
public class MenuContent implements Serializable{

    private String mName;
    private String mDescription;
    private Float mPrice;
    private ArrayList<String> mAllergens;
    private String mImageURL;
    private String mNotes;

    public MenuContent(String name,
                       String description,
                       Float price, ArrayList<String> allergens,
                       String imageURL,
                       String notes) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mAllergens = allergens;
        mImageURL = imageURL;
        mNotes = notes;
    }

    public MenuContent(String name, String description,
                       Float price,
                       ArrayList<String> allergens,
                       String imageURL) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mAllergens = allergens;
        mImageURL = imageURL;
        mNotes = "";
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Float getPrice() {
        return mPrice;
    }
    public void setPrice(Float price) {
        mPrice = price;
    }

    public String getImageURL() {
        return mImageURL;
    }

    public void setImageURL(String imageURL) {
        mImageURL = imageURL;
    }

    public ArrayList<String> getAllergens() {
        return mAllergens;
    }

    public void setAllergens(ArrayList<String> allergens) {
        mAllergens = allergens;
    }

    @Override
    public String toString() {
        return getName();
    }
}