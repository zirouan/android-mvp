package br.com.liveo.mvp.screen.home;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.liveo.mvp.databinding.ActivityHomeItemBinding;

/**
 * Created by rudsonlima on 8/29/17.
 */

class HomeViewHolder extends RecyclerView.ViewHolder {
    private final ActivityHomeItemBinding mBinding;

    HomeViewHolder(View view) {
        super(view);

        this.mBinding = DataBindingUtil.bind(view);
    }

    ViewDataBinding getBinding() {
        return mBinding;
    }
}
