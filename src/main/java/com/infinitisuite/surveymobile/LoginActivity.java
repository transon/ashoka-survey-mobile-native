package com.infinitisuite.surveymobile;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.infinitisuite.surveymobile.presenters.LoginPresenter;
import com.infinitisuite.surveymobile.views.LoginView;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends RoboActivity {

    private LoginPresenter mPresenter;

    private String mEmail;
    private String mPassword;

    @InjectView(R.id.email) EditText mEmailView;
    @InjectView(R.id.password) EditText mPasswordView;
    @InjectView(R.id.login_form) View mLoginFormView;
    @InjectView(R.id.login_status) View mLoginStatusView;
    @InjectView(R.id.login_status_message) TextView mLoginStatusMessageView;
    @InjectView(R.id.sign_in_button) View mSignInButtonView;
    @InjectView(R.id.errorView) TextView mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginView loginView = new LoginView(this, mEmailView, mPasswordView, mLoginFormView, mLoginStatusView, mLoginStatusMessageView, mSignInButtonView, mErrorView);
        mPresenter = new LoginPresenter(loginView);

        setContentView(R.layout.activity_login);

        mSignInButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.attemptLogin();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
}
