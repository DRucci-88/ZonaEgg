package id.ac.umn.zonaegg.data

import android.os.Parcel
import android.os.Parcelable

data class Eatery(
    var id: String?,
    var name: String?,
    var category: String?,
    var rating: Double?,
    var distance: Double?,
    var photoBackground: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(category)
        rating?.let { parcel.writeDouble(it) }
        distance?.let { parcel.writeDouble(it) }
        parcel.writeString(photoBackground)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Eatery> {
        override fun createFromParcel(parcel: Parcel): Eatery {
            return Eatery(parcel)
        }

        override fun newArray(size: Int): Array<Eatery?> {
            return arrayOfNulls(size)
        }
    }
}
