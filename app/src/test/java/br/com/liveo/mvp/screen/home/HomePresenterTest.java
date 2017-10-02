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
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
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

    private TestScheduler mTestScheduler;
    private HomeContract.Presenter mPresenter;

    @Mock
    public HomeContract.View mView;

    @Mock
    private UserResponse mUserResponse;

    @Mock
    private HomeContract.Interactor mInteractor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        when(mView.getPage()).thenReturn(2);
        when(mInteractor.fetchUsers(2)).thenReturn(Observable.just(mUserResponse));

        mTestScheduler = new TestScheduler();
        mPresenter = new HomePresenter(mInteractor, new TestSchedulerProvider(mTestScheduler));
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
    public void fetchUsers_returning_loadingSuccess_forView() {
        mPresenter.fetchUsers();

        verify(mView, times(1)).getPage();
        verify(mView, times(1)).onLoading(true);

        mTestScheduler.triggerActions();

        verify(mView, times(1)).onLoading(false);
    }

    @Test
    public void fetchUsers_returningSuccess_forView() {
        mPresenter.fetchUsers();

        mTestScheduler.triggerActions();

        verify(mView, times(1)).onUserResponse(mUserResponse);
        verify(mView, never()).onError(null);
    }

    @Test
    public void fetchUsers_returningFailing_forView() {
        Throwable throwable = new Throwable();
        when(mInteractor.fetchUsers(2)).thenReturn(Observable.error(throwable));

        mPresenter.fetchUsers();

        mTestScheduler.triggerActions();

        verify(mView).onError(throwable);
        verify(mView, times(1)).onLoading(false);
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
