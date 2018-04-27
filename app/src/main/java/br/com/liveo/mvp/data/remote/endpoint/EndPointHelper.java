package br.com.liveo.mvp.data.remote.endpoint;

import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Single;

/**
 * Created by rudsonlima on 8/29/17.
 */

public interface EndPointHelper {

    // User
    Single<UserResponse> fetchUsers(int page);
    // User
}
