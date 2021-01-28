package com.olayinkapeter.dummyapi_test;

import android.app.Activity;
import android.app.Application;

import com.olayinkapeter.dummyapi_test.di.component.ApplicationComponent;
import com.olayinkapeter.dummyapi_test.di.module.ContextModule;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static BaseApplication get(Activity activity){
        return (BaseApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}