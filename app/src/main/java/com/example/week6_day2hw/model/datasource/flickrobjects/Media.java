package com.example.week6_day2hw.model.datasource.flickrobjects;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media implements Parcelable
{

    @SerializedName("m")
    @Expose
    private String m;
    public final static Creator<Media> CREATOR = new Creator<Media>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        public Media[] newArray(int size) {
            return (new Media[size]);
        }

    }
            ;

    protected Media(Parcel in) {
        this.m = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Media() {
    }

    /**
     *
     * @param m
     */
    public Media(String m) {
        super();
        this.m = m;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(m);
    }

    public int describeContents() {
        return  0;
    }

}
