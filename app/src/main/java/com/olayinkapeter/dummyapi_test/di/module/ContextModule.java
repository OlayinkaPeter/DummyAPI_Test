package com.olayinkapeter.dummyapi_test.di.module;

import android.content.Context;

import com.olayinkapeter.dummyapi_test.di.ApplicationContext;
import com.olayinkapeter.dummyapi_test.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
