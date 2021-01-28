package com.olayinkapeter.dummyapi_test.di.component;

import android.content.Context;

import com.olayinkapeter.dummyapi_test.BaseApplication;
import com.olayinkapeter.dummyapi_test.data.UserService;
import com.olayinkapeter.dummyapi_test.di.ApplicationContext;
import com.olayinkapeter.dummyapi_test.di.module.ContextModule;
import com.olayinkapeter.dummyapi_test.di.module.RetrofitModule;
import com.olayinkapeter.dummyapi_test.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    UserService getUserService();

    @ApplicationContext
    Context getContext();

    void injectApplication(BaseApplication myApplication);
}

