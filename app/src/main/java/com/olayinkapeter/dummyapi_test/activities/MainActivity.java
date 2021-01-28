package com.olayinkapeter.dummyapi_test.activities;

import com.olayinkapeter.dummyapi_test.R;
import com.olayinkapeter.dummyapi_test.adapters.UserAdapter;
import com.olayinkapeter.dummyapi_test.client.Client;
import com.olayinkapeter.dummyapi_test.data.UserService;
import com.olayinkapeter.dummyapi_test.models.User;
import com.olayinkapeter.dummyapi_test.models.UserPack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements UserAdapter.OnUserItemClicked {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ProgressDialog progressDialog;

    private List<User> userList = new ArrayList<>();
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        callUserAPIService();
    }

    public void callUserAPIService(){
        UserService userService = Client.getRetrofitInstance().create(UserService.class);
        Call<UserPack> call = userService.getData(Client.LIMIT);

        call.enqueue(new Callback<UserPack>() {
            @Override
            public void onResponse(Call<UserPack> call, @NonNull Response<UserPack> response) {
                userList = response.body().getUsers();
                progressDialog.dismiss();
                userAdapter = new UserAdapter(userList, R.layout.user_item, getApplicationContext());
                userAdapter.setListener(MainActivity.this);
                recyclerView.setAdapter(userAdapter);
                Log.d(TAG, "Number of users received: " + userList.size());
            }

            @Override
            public void onFailure(Call<UserPack> call, Throwable throwable) {
                progressDialog.dismiss();
                Log.e(TAG, throwable.toString());
            }
        });
    }


    @Override
    public void containerClicked(int position) {
        User user = userList.get(position);

        Intent intent = new Intent(MainActivity.this, SingleUserActivity.class);
        intent.putExtra("user_id", user.getUserID());

        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
