package br.com.liveo.mvp.screen.home;

import org.junit.After;
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

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
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

    @After
    public void tearDown() {
        mPresenter.detachView();
    }

    @Test
    public void fetchUsers_sucess(){
        mInteractor.fetchUsers(2);
        verify(mInteractor, times(1)).fetchUsers(2);
    }

    @Test
    public void fetchUsers_returningSuccess_forView() {
        mView.onLoading(true);
        mInteractor.fetchUsers(2);
        mView.onLoading(false);

        verify(mView, times(1)).onLoading(true);
        verify(mView, times(1)).onLoading(false);

        mView.onUserResponse(mUserResponse);
        verify(mView, times(1)).onUserResponse(mUserResponse);
        verify(mView, never()).onError("Error");
    }

    @Test
    public void fetchUsers_returningFailing_forView() {
        Throwable throwable = new Throwable();
        when(mInteractor.fetchUsers(2)).thenReturn(Observable.error(throwable));

        mInteractor.fetchUsers(2);

        mView.onLoading(false);
        mView.onError(throwable.getMessage());

        verify(mView, times(1)).onLoading(false);
        verify(mView, times(1)).onError(throwable.getMessage());
        verify(mView, never()).onUserResponse(mUserResponse);
    }

    @Test
    public void attach_isNotNUll_sucess(){
        Assert.assertNotNull(mPresenter.getView());
    }

    @Test
    public void detachView_isNUll_sucess(){
        Assert.assertNotNull(mPresenter.getView());

        mPresenter.detachView();
        Assert.assertNull(mPresenter.getView());
    }
}
