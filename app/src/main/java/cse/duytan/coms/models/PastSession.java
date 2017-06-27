package cse.duytan.coms.models;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class PastSession {
    private String name;
    private String time;
    private String location;
    private boolean isSelected;

    public PastSession() {
    }

    public PastSession(String name, String time, String location, boolean isSelected) {
        this.name = name;
        this.time = time;
        this.location = location;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
