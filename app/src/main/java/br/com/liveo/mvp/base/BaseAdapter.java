package br.com.liveo.mvp.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by rudsonlima on 9/16/17.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> dataList;

    private final PublishSubject<T> onItemClick = PublishSubject.create();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewHolderBase(parent, viewType);
    }

    public abstract RecyclerView.ViewHolder onCreateViewHolderBase(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        this.onBindViewHolderBase(holder, position);

        holder.itemView.setOnClickListener(v -> onItemClick.onNext(dataList.get(holder.getAdapterPosition())));
    }

    public abstract void onBindViewHolderBase(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return dataList != null && dataList.size() > 0 ? dataList.size() : 0;
    }

    public T getItem(int index) {
        if (dataList != null && dataList.get(index) != null) {
            return dataList.get(index);
        } else {
            throw new IllegalArgumentException("Item with index " + index + " doesn't exist, dataSet is " + dataList);
        }
    }

    public Observable<T> observableItemClick() {
        return onItemClick;
    }
}
