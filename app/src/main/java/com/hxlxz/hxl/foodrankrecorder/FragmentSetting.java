package com.hxlxz.hxl.foodrankrecorder;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSetting extends Fragment {


    public FragmentSetting() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null)
            inputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getActivity().getCurrentFocus() != null)
            getActivity().getCurrentFocus().clearFocus();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getActivity().getCurrentFocus() != null)
            getActivity().getCurrentFocus().clearFocus();
        getActivity().findViewById(R.id.content).requestFocus();
        ((Button) getView().findViewById(R.id.buttonSyncAccountSetting)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(new FragmentLogin());
            }
        });
        ((Button) getView().findViewById(R.id.buttonFriendManage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(new FragmentFriend());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_setting, container, false);
        return view;
    }
}
