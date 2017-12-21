package br.com.liveo.mvp.base;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import br.com.liveo.mvp.model.User;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class BaseModel {

    public String errorMessage;
    public String successMessage;

    @BindingAdapter("imageLoadRounded")
    public static void setImageLoadRounded(final ImageView imageView, String urlImage){
        if (!TextUtils.isEmpty(urlImage)) {
            Glide.with(imageView.getContext()).load(urlImage).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(imageView.getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
    }

    @BindingAdapter("nameWithLastName")
    public static void setNameWithLastName(TextView textView, User user){
        textView.setText(String.format("%s %s", user.getName(), user.getLastName()));
    }
}
