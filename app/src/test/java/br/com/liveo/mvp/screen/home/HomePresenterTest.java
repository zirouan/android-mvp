package br.com.liveo.mvp.screen.home;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class makes tests for {@link HomePresenter}
 *
 * @author Rudson Lima
 * @since 09/16/17
 */
@RunWith(JUnit4.class)
public class HomePresenterTest {

    @InjectMocks
    public HomePresenter mPresenter;

    @Mock
    private HomeInteractor mInteractor;

    @Mock
    public HomeContract.View mView;

    @Mock
    private UserResponse mUserResponse;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        when(mInteractor.fetchUsers(2)).thenReturn(Observable.just(mUserResponse));
        mPresenter.attach(mView);
    }

    @Test
    public void fetchUsers_sucess(){
        mInteractor.fetchUsers(2);
        verify(mInteractor).fetchUsers(2);
    }

    @Test
    public void fetchUsers_returningSuccess_forView() {
        mView.onLoading(true);
        mInteractor.fetchUsers(2);
        mView.onLoading(false);

        verify(mView).onLoading(true);
        verify(mView).onLoading(false);

        mView.onUserResponse(mUserResponse);
        verify(mView).onUserResponse(mUserResponse);
    }

    @Test
    public void fetchUsers_returningFailing_forView() {
        mView.onLoading(false);
        mView.onError("Error fetching users");

        verify(mView).onLoading(false);
        verify(mView).onError("Error fetching users");
    }

    @Test
    public void detachView_isNUll_sucess(){
        mPresenter.detachView();
        Assert.assertNull(mPresenter.getView());
    }
}
