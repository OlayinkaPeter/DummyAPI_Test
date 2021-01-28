package com.olayinkapeter.dummyapi_test.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.olayinkapeter.dummyapi_test.R;
import com.olayinkapeter.dummyapi_test.client.Client;
import com.olayinkapeter.dummyapi_test.data.UserService;
import com.olayinkapeter.dummyapi_test.models.User;
import com.olayinkapeter.dummyapi_test.models.UserDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserActivity extends AppCompatActivity {
    private static final String TAG = SingleUserActivity.class.getSimpleName();
    private CompositeDisposable disposable = new CompositeDisposable();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bg_image)
    ImageView imageBG;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.full_name)
    TextView fullName;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.gender)
    TextView gender;
    @BindView(R.id.country)
    TextView country;
    @BindView(R.id.dob)
    TextView dob;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.reg_date)
    TextView regDate;

    ProgressDialog progressDialog;

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        userID = Objects.requireNonNull(intent.getExtras()).getString("user_id");

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        getUserDetails(userID);
    }

    public void getUserDetails(String userID) {
        UserService userService = Client.getRetrofitInstance().create(UserService.class);
        Call<UserDetail> call = userService.getUserDetails(userID);

        call.enqueue(new Callback<UserDetail>() {
            @Override
            public void onResponse(Call<UserDetail> call, @NonNull Response<UserDetail> response) {
                final UserDetail userDetail = response.body();
                renderUserDetails(userDetail);

                progressDialog.dismiss();
                Log.d(TAG, "Great! User detail loaded.");
            }

            @Override
            public void onFailure(Call<UserDetail> call, Throwable throwable) {
                progressDialog.dismiss();
                Log.e(TAG, throwable.toString());
                Toast.makeText(getApplicationContext(), "Error loading!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void renderUserDetails(UserDetail userDetail) {
        String userFullName = userDetail.getFirstName()
                + " " + userDetail.getLastName()
                + " (" + userDetail.getTitle()
                + ")";

        fullName.setText(userFullName);
        email.setText(userDetail.getEmail());
        phone.setText(userDetail.getPhone());
        gender.setText(userDetail.getGender());
        dob.setText(userDetail.getDateOfBirth());
        regDate.setText(userDetail.getRegisterDate());

        Glide.with(this).load(userDetail.getPicture())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(200)))
                .into(image);

        Glide.with(this).load(userDetail.getPicture())
                .into(imageBG);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
