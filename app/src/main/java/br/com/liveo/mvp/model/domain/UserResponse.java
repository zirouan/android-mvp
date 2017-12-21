package br.com.liveo.mvp.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.liveo.mvp.base.BaseModel;
import br.com.liveo.mvp.model.User;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class UserResponse extends BaseModel {

    public int page;

    public int total;

    @SerializedName("per_page")
    public int perPage;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("data")
    public List<User> list;
}
