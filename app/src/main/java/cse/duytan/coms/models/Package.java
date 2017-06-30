package cse.duytan.coms.models;

/**
 * Created by Pham Van Thien on 6/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Package {
    private int id;
    private String name;
    private String price;
    private int image;

    public Package() {
    }

    public Package(int id, String name, String price, int image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
