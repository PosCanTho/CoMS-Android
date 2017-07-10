package cse.duytan.coms.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Pham Van Thien on 7/6/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class User {
    @SerializedName("Table")
    public List<Table> Table;

    public static class Table {
        @SerializedName("USER_ID")
        public String USER_ID;
        @SerializedName("UserName")
        public String UserName;
        @SerializedName("STUDENT_ID_NUMBER")
        public String STUDENT_ID_NUMBER;
        @SerializedName("INSTRUCTOR_ID_NUMBER")
        public String INSTRUCTOR_ID_NUMBER;
        @SerializedName("CURRENT_LAST_NAME")
        public String CURRENT_LAST_NAME;
        @SerializedName("CURRENT_MIDDLE_NAME")
        public String CURRENT_MIDDLE_NAME;
        @SerializedName("CURRENT_FIRST_NAME")
        public String CURRENT_FIRST_NAME;
        @SerializedName("ROLE_TYPE")
        public String ROLE_TYPE;

        public Table() {
        }

        public Table(String USER_ID, String userName, String STUDENT_ID_NUMBER, String INSTRUCTOR_ID_NUMBER, String CURRENT_LAST_NAME, String CURRENT_MIDDLE_NAME, String CURRENT_FIRST_NAME, String ROLE_TYPE) {
            this.USER_ID = USER_ID;
            UserName = userName;
            this.STUDENT_ID_NUMBER = STUDENT_ID_NUMBER;
            this.INSTRUCTOR_ID_NUMBER = INSTRUCTOR_ID_NUMBER;
            this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
            this.CURRENT_MIDDLE_NAME = CURRENT_MIDDLE_NAME;
            this.CURRENT_FIRST_NAME = CURRENT_FIRST_NAME;
            this.ROLE_TYPE = ROLE_TYPE;
        }

        public String getUSER_ID() {
            return USER_ID;
        }

        public void setUSER_ID(String USER_ID) {
            this.USER_ID = USER_ID;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getSTUDENT_ID_NUMBER() {
            return STUDENT_ID_NUMBER;
        }

        public void setSTUDENT_ID_NUMBER(String STUDENT_ID_NUMBER) {
            this.STUDENT_ID_NUMBER = STUDENT_ID_NUMBER;
        }

        public String getINSTRUCTOR_ID_NUMBER() {
            return INSTRUCTOR_ID_NUMBER;
        }

        public void setINSTRUCTOR_ID_NUMBER(String INSTRUCTOR_ID_NUMBER) {
            this.INSTRUCTOR_ID_NUMBER = INSTRUCTOR_ID_NUMBER;
        }

        public String getCURRENT_LAST_NAME() {
            return CURRENT_LAST_NAME;
        }

        public void setCURRENT_LAST_NAME(String CURRENT_LAST_NAME) {
            this.CURRENT_LAST_NAME = CURRENT_LAST_NAME;
        }

        public String getCURRENT_MIDDLE_NAME() {
            return CURRENT_MIDDLE_NAME;
        }

        public void setCURRENT_MIDDLE_NAME(String CURRENT_MIDDLE_NAME) {
            this.CURRENT_MIDDLE_NAME = CURRENT_MIDDLE_NAME;
        }

        public String getCURRENT_FIRST_NAME() {
            return CURRENT_FIRST_NAME;
        }

        public void setCURRENT_FIRST_NAME(String CURRENT_FIRST_NAME) {
            this.CURRENT_FIRST_NAME = CURRENT_FIRST_NAME;
        }

        public String getROLE_TYPE() {
            return ROLE_TYPE;
        }

        public void setROLE_TYPE(String ROLE_TYPE) {
            this.ROLE_TYPE = ROLE_TYPE;
        }
    }
}
