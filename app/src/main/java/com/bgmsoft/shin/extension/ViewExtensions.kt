package com.bgmsoft.shin.extension

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

fun ImageView.setImageFromUrl(imageUrl: Uri, isCircle: Boolean = false) {
    val options = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .dontAnimate()

    Glide.with(this)
        .load(imageUrl)
        .placeholder(null)
        .apply(
            if (isCircle)
                RequestOptions()
                    .centerCrop()
                    .circleCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .dontAnimate()
            else
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(true)
                    .dontAnimate()
        )
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                this@setImageFromUrl.setImageDrawable(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                this@setImageFromUrl.setImageDrawable(placeholder)
            }
        })

}