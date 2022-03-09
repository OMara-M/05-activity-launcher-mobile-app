package edu.temple.imageactivitylauncher

import android.os.Parcel
import android.os.Parcelable

data class ImageData(val resourceId: Int, val description: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(resourceId)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageData> {
        override fun createFromParcel(parcel: Parcel): ImageData {
            return ImageData(parcel)
        }

        override fun newArray(size: Int): Array<ImageData?> {
            return arrayOfNulls(size)
        }
    }
}