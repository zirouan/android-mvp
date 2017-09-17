package br.com.liveo.mvp.screen.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.liveo.mvp.BR;
import br.com.liveo.mvp.R;
import br.com.liveo.mvp.base.BaseAdapter;
import br.com.liveo.mvp.model.User;
import br.com.liveo.mvp.model.domain.UserResponse;

/**
 * Created by rudsonlima on 8/29/17.
 */

class HomeAdapter extends BaseAdapter<User> {

    HomeAdapter(UserResponse userResponse) {
        this.dataList = userResponse.list;
    }

    public void setData(List<User> list){
        this.dataList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolderBase(ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_item, parent, false));
    }

    @Override
    public void onBindViewHolderBase(RecyclerView.ViewHolder holder, int position) {
        final User user = dataList.get(position);

        ((HomeViewHolder)holder).getBinding().setVariable(BR.user, user);
        ((HomeViewHolder)holder).getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
