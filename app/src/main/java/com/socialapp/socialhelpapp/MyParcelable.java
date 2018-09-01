package com.socialapp.socialhelpapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {

    public String mName;
    public String mPrice;

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
    }

    public MyParcelable(String mName, String mPrice) {
        this.mName = mName;
        this.mPrice = mPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName);
        out.writeString(mPrice);
    }
}
