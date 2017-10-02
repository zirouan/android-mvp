package br.com.liveo.mvp.screen.home;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.liveo.mvp.data.source.remote.ApiEndPoint;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class makes tests for {@link HomeInteractor}
 *
 * @author Rudson Lima
 * @since 09/20/17
 */
public class HomeInteractorTest {

    @Mock
    private ApiEndPoint mApiEndPoint;

    @Mock
    private HomeContract.Interactor mInteractor;

    @InjectMocks
    private HomeInteractor mHomeInteractor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mInteractor = mHomeInteractor;
        when(mInteractor.fetchUsers(2)).thenReturn(Observable.just(new UserResponse()));
    }

    @Test
    public void fetchUsers_sucess() {
        mInteractor.fetchUsers(2);
        verify(mApiEndPoint).fetchUsers(2);
    }

    @Test
    public void fetchUsers_noErros_sucess() {
        TestObserver<UserResponse> subscriber = TestObserver.create();
        mApiEndPoint.fetchUsers(2).subscribe(subscriber);
        subscriber.onNext(new UserResponse());
        subscriber.assertNoErrors();
        subscriber.assertComplete();
    }
}
