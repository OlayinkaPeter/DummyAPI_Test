package com.olayinkapeter.dummyapi_test.di.module;

import com.olayinkapeter.dummyapi_test.di.scope.ActivityScope;
import com.olayinkapeter.dummyapi_test.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
    private final MainActivityContract.View mView;


    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainActivityContract.View provideView() {
        return mView;
    }


}
