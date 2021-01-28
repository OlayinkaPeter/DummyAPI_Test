package com.olayinkapeter.dummyapi_test.data;

import com.olayinkapeter.dummyapi_test.models.UserDetail;
import com.olayinkapeter.dummyapi_test.models.UserPack;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    // USERS
    @Headers("app-id: 600fea2ba09bc770c4af4240")
    @GET("/data/api/user")
    Call<UserPack> getData(@Query("limit") int limit);

    // SINGLE USER
    @Headers("app-id: 600fea2ba09bc770c4af4240")
    @GET("/data/api/user/{id}")
    Call<UserDetail> getUserDetails(@Path("id") String userID);

}
