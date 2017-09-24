package br.com.liveo.mvp.screen.home;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.liveo.mvp.model.domain.UserResponse;
import br.com.liveo.mvp.util.scheduler.TestSchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

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

    @Mock
    private HomeInteractor mInteractor;

    @Mock
    public HomeContract.View mView;

    @Mock
    public HomeContract.Presenter mPresenter;

    @Mock
    private UserResponse mUserResponse;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        when(mView.getPage()).thenReturn(2);
        when(mInteractor.fetchUsers(2)).thenReturn(Observable.just(mUserResponse));

        mPresenter = new HomePresenter(mInteractor, new TestSchedulerProvider(new TestScheduler()));
        mPresenter.attach(mView);
    }

    @After
    public void tearDown() {
        mPresenter.detachView();
    }

    @Test
    public void fetchUsers_sucess(){
        mPresenter.fetchUsers();
        verify(mInteractor, times(1)).fetchUsers(2);
    }

    @Test
    public void fetchUsers_returningSuccess_forView() {
        mPresenter.fetchUsers();

        verify(mView, times(1)).getPage();
        verify(mView, times(1)).onLoading(true);

        mView.onUserResponse(mUserResponse);
        verify(mView, times(1)).onUserResponse(mUserResponse);
        verify(mView, never()).onError("Error");
    }

    @Test
    public void fetchUsers_returningFailing_forView() {
        Throwable throwable = new Throwable();
        when(mInteractor.fetchUsers(2)).thenReturn(Observable.error(throwable));

        mPresenter.fetchUsers();

        mView.onError(throwable.getMessage());
        verify(mView, times(1)).onError(throwable.getMessage());
        verify(mView, never()).onUserResponse(mUserResponse);
    }

    @Test
    public void attach_isNotNull_sucess(){
        Assert.assertNotNull(mPresenter.getView());
    }

    @Test
    public void detachView_isNull_sucess(){
        Assert.assertNotNull(mPresenter.getView());

        mPresenter.detachView();
        Assert.assertNull(mPresenter.getView());
    }
}
