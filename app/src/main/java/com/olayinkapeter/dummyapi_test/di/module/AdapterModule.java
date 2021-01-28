package com.olayinkapeter.dummyapi_test.di.module;

import com.olayinkapeter.dummyapi_test.activities.MainActivity;
import com.olayinkapeter.dummyapi_test.adapters.UserAdapter;
import com.olayinkapeter.dummyapi_test.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {
}