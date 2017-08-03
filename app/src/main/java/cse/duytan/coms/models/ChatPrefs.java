package cse.duytan.coms.models;

/**
 * Created by Pham Van Thien on 8/3/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ChatPrefs {
    private int personIdFrom;
    private int personIdTo;
    private String name;

    public ChatPrefs() {
    }

    public ChatPrefs(int personIdFrom, int personIdTo, String name) {
        this.personIdFrom = personIdFrom;
        this.personIdTo = personIdTo;
        this.name = name;
    }

    public int getPersonIdFrom() {
        return personIdFrom;
    }

    public void setPersonIdFrom(int personIdFrom) {
        this.personIdFrom = personIdFrom;
    }

    public int getPersonIdTo() {
        return personIdTo;
    }

    public void setPersonIdTo(int personIdTo) {
        this.personIdTo = personIdTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
