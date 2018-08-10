package com.tuann.mvvm.ui.common.binding

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.tuann.mvvm.R

@BindingAdapter("image_url")
fun setImageFromImageUrl(imageView: ImageView, imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        return
    }
    Glide
            .with(imageView.context)
            .load(imageUrl)
            .apply {
                RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .dontAnimate()
                        .transform(CircleCrop())
            }
            .into(imageView)
}