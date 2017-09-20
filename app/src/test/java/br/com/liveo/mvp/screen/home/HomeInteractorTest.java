package br.com.liveo.mvp.screen.home;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.liveo.mvp.data.source.remote.ApiEndPoint;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

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
    private HomeInteractor mInteractor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mInteractor = new HomeInteractor(mApiEndPoint);
        when(mInteractor.fetchUsers(2)).thenReturn(Observable.just(new UserResponse()));
    }

    @Test
    public void fetchCompany_sucess() {
        TestObserver<UserResponse> subscriber = TestObserver.create();
        mInteractor.fetchUsers(2).subscribe(subscriber);
        subscriber.onNext(new UserResponse());
        subscriber.assertNoErrors();
        subscriber.assertComplete();
    }
}
