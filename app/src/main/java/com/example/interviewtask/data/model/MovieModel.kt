package com.example.interviewtask.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class MovieModel(
    @PrimaryKey
    @SerializedName("id") var id: String,

    @SerializedName("title") var title: String,

    @SerializedName("release_date")var releaseDate: String,
    @SerializedName("poster_path")var posterImage: String?,
    @SerializedName("backdrop_path")var backdropImage: String?,
    @SerializedName("adult")var adult: Boolean,
    @SerializedName("page")var page: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(releaseDate)
        parcel.writeString(posterImage)
        parcel.writeString(backdropImage)
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeInt(page)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }

}
