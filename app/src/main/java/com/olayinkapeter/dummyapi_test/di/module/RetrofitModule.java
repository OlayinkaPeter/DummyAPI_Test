package com.olayinkapeter.dummyapi_test.di.module;

import com.olayinkapeter.dummyapi_test.data.UserService;
import com.olayinkapeter.dummyapi_test.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://dummyapi.io";
    public static int LIMIT = 100;



    @Provides
    @ApplicationScope
    UserService userService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

    @Provides
    @ApplicationScope
    Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

