package com.example.interviewtask.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class MovieDetailBindingAdapter {


    companion object {
        @JvmStatic
        @BindingAdapter("setBannerImage")
        fun setBannerImage(view: ImageView, imagePath: String?) {
            imagePath?.let {
                Picasso.get().load("${Constant.IMAGE_BASE_URL}${imagePath}").into(view)
            }
        }

        @JvmStatic
        @BindingAdapter("setPosterImage")
        fun setPosterImage(view: ImageView, imagePath: String?) {
            imagePath?.let {
                Picasso.get().load("${Constant.IMAGE_DETAIL_BASE_URL}${imagePath}").into(view)
            }
        }
    }
}