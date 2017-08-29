package com.example.rent.supercv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PasswordFragment extends DialogFragment {

    private static final String PASSWORD = "123";
    private static final int VIBRATION_TIME = 500;
    private Animation shake;
    private Vibrator vibrator;

    @BindView(R.id.editTextPassword)
    EditText passwordEditText;

    public static PasswordFragment newInstance() {
        return new PasswordFragment();
    }

    public PasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
        this.setCancelable(false);
    }

    @OnClick(R.id.buttonPassword)
    public void checkPassword() {
        if (isPasswordValid())
            this.dismiss();
        else
            notifyAuthenticationFailed();
    }

    private boolean isPasswordValid() {
        String userInput = passwordEditText.getText().toString();
        return userInput.equals(PASSWORD);
    }

    private void notifyAuthenticationFailed() {
        passwordEditText.setText("");
        passwordEditText.startAnimation(shake);
        vibrate();
    }

    private void vibrate() {
        vibrator.vibrate(VIBRATION_TIME);
    }
}