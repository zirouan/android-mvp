package br.com.liveo.mvp.screen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;

import javax.inject.Inject;

import br.com.liveo.mvp.App;
import br.com.liveo.mvp.R;
import br.com.liveo.mvp.base.BaseActivity;
import br.com.liveo.mvp.base.BaseException;
import br.com.liveo.mvp.databinding.ActivityHomeBinding;
import br.com.liveo.mvp.model.User;
import br.com.liveo.mvp.model.domain.UserResponse;
import br.com.liveo.mvp.model.exception.ListException;
import br.com.liveo.mvp.screen.home.di.HomeModule;
import br.com.liveo.mvp.util.Util;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;

/**
 * Created by rudsonlima on 8/29/17.
 */
public class HomeActivity extends BaseActivity implements HomeContract.View {

    private ActivityHomeBinding mBinding;

    @Inject
    public HomeContract.Presenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.onInitInject();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.fetchUsers();
    }

    private void onInitView(){
        mBinding = (ActivityHomeBinding) this.bindView(R.layout.activity_home);

        this.onInitToolbar(mBinding.includeToolbar.toolbar, R.string.app_name);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBinding.swipeContainer.setOnRefreshListener(onRefresh);
        mBinding.swipeContainer.setColorSchemeResources(R.color.accent, R.color.accent,
                R.color.accent, R.color.accent);
    }

    private void onInitInject() {
        this.getAppComponent().module(new HomeModule()).inject(this);

        this.onInitView();
    }

    private SwipeRefreshLayout.OnRefreshListener onRefresh = this::fetchUsers;

    private void fetchUsers() {
        this.mHomePresenter.attach(this);
        this.mHomePresenter.fetchUsers();
    }

    @Override
    public void onLoading(boolean isLoading) {
        mBinding.swipeContainer.setRefreshing(isLoading);
    }

    @Override
    public void onError(Throwable error) {
        if (error != null && error instanceof ListException) {
            int stringRes = ((ListException) error).getStringRes();

            if (stringRes != BaseException.DEFAULT_CODE) {
                this.toastLong(getString(stringRes));
                return;
            }
        } else if (error != null && error instanceof HttpException) {
            String message = Util.getMessageErro(((HttpException) error));
            if (!TextUtils.isEmpty(message)) {
                this.toastLong(message);
                return;
            }
        }

        this.toastLong(R.string.error_users);
    }

    @Override
    public int getPage() {
        return 2;
    }

    @Override
    public void onUserResponse(UserResponse userResponse) {
        if (userResponse != null){
            HomeAdapter adapter = new HomeAdapter(userResponse);
            adapter.observableItemClick().subscribe(onItemClick);

            mBinding.recyclerView.setAdapter(adapter);
        }
    }

    Consumer<User> onItemClick = contact ->
            this.toastShort(contact.getName());

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHomePresenter.detachView();
    }
}
