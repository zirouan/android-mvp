package br.com.liveo.mvp.screen.home;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.liveo.mvp.data.remote.EndPoint;
import br.com.liveo.mvp.data.remote.helper.EndPointHelper;
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
    private EndPointHelper mApiEndPointHelper;

    @Mock
    private HomeContract.Interactor mInteractor;

    @InjectMocks
    private HomeInteractor mHomeInteractor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mInteractor = mHomeInteractor;
        when(mInteractor.fetchUsers(2)).thenReturn(Single.just(new UserResponse()));
    }

    @Test
    public void fetchUsers_sucess() {
        mInteractor.fetchUsers(2);
        verify(mApiEndPointHelper).fetchUsers(2);
    }

    @Test
    public void fetchUsers_noErros_sucess() {
        TestObserver<UserResponse> subscriber = TestObserver.create();
        mApiEndPointHelper.fetchUsers(2).subscribe(subscriber);
        subscriber.onNext(new UserResponse());
        subscriber.assertNoErrors();
        subscriber.assertComplete();
    }
}
