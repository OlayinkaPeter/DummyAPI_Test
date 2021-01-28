package com.olayinkapeter.dummyapi_test.mvp;

import com.olayinkapeter.dummyapi_test.data.UserService;
import com.olayinkapeter.dummyapi_test.models.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresenterImpl implements MainActivityContract.Presenter {

    UserService userService;
    MainActivityContract.View mView;

    @Inject
    public PresenterImpl(UserService userService, MainActivityContract.View mView) {
        this.userService = userService;
        this.mView = mView;
    }

    @Override
    public void loadData() {

        mView.showProgress();
    }
}

