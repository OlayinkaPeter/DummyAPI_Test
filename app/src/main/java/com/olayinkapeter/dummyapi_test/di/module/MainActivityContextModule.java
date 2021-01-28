package com.olayinkapeter.dummyapi_test.di.module;

import android.content.Context;

import com.olayinkapeter.dummyapi_test.activities.MainActivity;
import com.olayinkapeter.dummyapi_test.di.ActivityContext;
import com.olayinkapeter.dummyapi_test.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}
