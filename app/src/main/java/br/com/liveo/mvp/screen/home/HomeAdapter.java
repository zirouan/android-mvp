package br.com.liveo.mvp.screen.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.liveo.mvp.BR;
import br.com.liveo.mvp.R;
import br.com.liveo.mvp.model.User;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private List<User> userList;
    private final PublishSubject<User> onItemClick = PublishSubject.create();

    public HomeAdapter(UserResponse userResponse) {
        this.userList = userResponse.list;
    }

    public void setData(List<User> list){
        this.userList = list;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        final User user = userList.get(position);

        holder.getBinding().setVariable(BR.user, user);
        holder.getBinding().executePendingBindings();

        holder.itemView.setOnClickListener(v -> onItemClick.onNext(user));
    }

    @Override
    public int getItemCount() {
        return userList != null && userList.size() > 0 ? userList.size() : 0;
    }

    Observable<User> observableItemClick() {
        return onItemClick;
    }
}
