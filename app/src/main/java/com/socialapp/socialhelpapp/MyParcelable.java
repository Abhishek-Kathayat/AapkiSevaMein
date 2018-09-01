package com.socialapp.socialhelpapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {

    public String mName;
    public String mPrice;
    public String mthumb;

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel parcel) {
            return new MyParcelable(parcel);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    private MyParcelable(Parcel parcel) {
        mName = parcel.readString();
        mPrice = parcel.readString();
        mthumb = parcel.readString();
    }

    public MyParcelable(String mName, String mPrice, String mthumb) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mthumb = mthumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName);
        out.writeString(mPrice);
        out.writeString(mthumb);
    }
}
