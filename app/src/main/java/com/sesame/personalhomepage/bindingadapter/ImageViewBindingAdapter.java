package com.sesame.personalhomepage.bindingadapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class ImageViewBindingAdapter {

    // TODO: 2021/7/30 ??
    @BindingAdapter(value = {"image", "defaultImageResource"}, requireAll = false)
    public static void setImage(ImageView imageView, String imageUrl, int imageResource) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.get().load(imageUrl).into(imageView);
        } else {
            imageView.setBackgroundColor(Color.DKGRAY);
//            imageView.setImageResource(imageResource);
        }
    }
}
