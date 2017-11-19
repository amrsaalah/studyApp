package com.bignerdranch.android.studyapp.RetrofitModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * Created by user on 10/27/2017.
 */
public class Posts implements Serializable {

    @SerializedName("username")
    String username;
    @SerializedName("email")
    String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
