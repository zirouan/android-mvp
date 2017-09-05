package br.com.liveo.mvp.screen.home;

import org.junit.Before;
import org.junit.Test;

import br.com.liveo.mvp.base.BaseView;

import static org.junit.Assert.assertTrue;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class HomeContractTest {

    private Class entryClassView;
    private Class entryClassPresenter;

    @Before
    public void onInit(){
        this.entryClassView = HomeContract.View.class;
        this.entryClassPresenter = HomeContract.Presenter.class;
    }

    @Test
    public void homeContractView_isBaseView() {
        assertTrue(BaseView.class.isAssignableFrom(this.entryClassView));
    }

    @Test
    public void homeContractView_isHomeContractView() {
        assertTrue(HomeContract.View.class.isAssignableFrom(this.entryClassView));
    }

    @Test
    public void homeContractPresenter_isHomeContractPresenter() {
        assertTrue(HomeContract.Presenter.class.isAssignableFrom(this.entryClassPresenter));
    }
}
