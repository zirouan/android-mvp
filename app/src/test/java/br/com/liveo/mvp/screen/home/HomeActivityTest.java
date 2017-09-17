package br.com.liveo.mvp.screen.home;

import org.junit.Before;
import org.junit.Test;

import br.com.liveo.mvp.base.BaseView;

import static org.junit.Assert.assertTrue;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class HomeActivityTest {

    private Class entryClass;

    @Before
    public void setUp(){
        this.entryClass = HomeActivity.class;
    }

    @Test
    public void homeView_isBaseView() {
        assertTrue(BaseView.class.isAssignableFrom(entryClass));
    }

    @Test
    public void homeView_isHomeContractView() {
        assertTrue(HomeContract.View.class.isAssignableFrom(entryClass));
    }
}
