package com.socialapp.socialhelpapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {

    private int mData;
    private String mName;

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
        mData = parcel.readInt();
        mName = parcel.readString();
    }

    public MyParcelable() {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
        out.writeString(mName);
    }
}
