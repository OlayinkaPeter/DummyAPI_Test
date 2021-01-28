package com.olayinkapeter.dummyapi_test.mvp;

import com.olayinkapeter.dummyapi_test.models.User;

import java.util.List;

public interface MainActivityContract {
    interface View {
        void showData(List<User> userList);
        void showError(String message);
        void showComplete();
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void loadData();
    }
}
