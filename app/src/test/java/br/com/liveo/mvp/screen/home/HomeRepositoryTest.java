package br.com.liveo.mvp.screen.home;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.liveo.mvp.data.remote.endpoint.EndPointHelper;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class makes tests for {@link HomeRepository}
 *
 * @author Rudson Lima
 * @since 09/20/17
 */
public class HomeRepositoryTest {

    @Mock
    private EndPointHelper mApiEndPointHelper;

    @Mock
    private HomeContract.Repository mRepository;

    @InjectMocks
    private HomeRepository mHomeRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mRepository = mHomeRepository;
        when(mRepository.fetchUsers(2)).thenReturn(Single.just(new UserResponse()));
    }

    @Test
    public void fetchUsers_sucess() {
        mRepository.fetchUsers(2);
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
