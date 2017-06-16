package com.hxlxz.hxl.foodrankrecorder;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAdd extends Fragment {


    public FragmentAdd() {
        // Required empty public constructor
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getActivity().getCurrentFocus() != null)
            getActivity().getCurrentFocus().clearFocus();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null)
            inputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getActivity().getCurrentFocus() != null)
            getActivity().getCurrentFocus().clearFocus();
        getActivity().findViewById(R.id.content).requestFocus();
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) getView().findViewById(R.id.toolbarAdd));
        getView().findViewById(R.id.buttonShopAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(new FragmentAddShop());
            }
        });
        getView().findViewById(R.id.buttonFoodAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(new FragmentAddFood());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_add, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbat_add, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
