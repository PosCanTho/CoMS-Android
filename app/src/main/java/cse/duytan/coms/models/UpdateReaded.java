package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pham Van Thien on 8/31/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class UpdateReaded {

    @SerializedName("PersonId")
    private int PersonId;
    @SerializedName("NumberUnread")
    private int NumberUnread;

    public UpdateReaded() {
    }

    public UpdateReaded(int personId, int numberUnread) {
        PersonId = personId;
        NumberUnread = numberUnread;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int PersonId) {
        this.PersonId = PersonId;
    }

    public int getNumberUnread() {
        return NumberUnread;
    }

    public void setNumberUnread(int NumberUnread) {
        this.NumberUnread = NumberUnread;
    }
}
