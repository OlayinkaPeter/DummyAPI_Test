package com.olayinkapeter.dummyapi_test.di.component;

import android.content.Context;

import com.olayinkapeter.dummyapi_test.activities.MainActivity;
import com.olayinkapeter.dummyapi_test.di.ActivityContext;
import com.olayinkapeter.dummyapi_test.di.module.AdapterModule;
import com.olayinkapeter.dummyapi_test.di.module.MainActivityMvpModule;
import com.olayinkapeter.dummyapi_test.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}