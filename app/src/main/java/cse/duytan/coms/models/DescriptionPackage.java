package cse.duytan.coms.models;

/**
 * Created by Pham Van Thien on 6/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class DescriptionPackage {
    private int id;
    private String name;

    public DescriptionPackage() {
    }

    public DescriptionPackage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
