package restaurant.fjc.com.model;

/**
 * Created by javier on 11/5/16.
 */
public class MenuContent {

    private String mName;
    private String mDescription;
    private Float mPrice;
    private String mImageURL;

    public MenuContent(String name, String description, Float price, String imageURL) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mImageURL = imageURL;
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
}