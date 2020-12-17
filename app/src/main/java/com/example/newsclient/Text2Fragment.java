package com.example.newsclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Text2Fragment extends Fragment {

    private View inflate;


    public static Text2Fragment newInstance() {

        Bundle args = new Bundle();

        Text2Fragment fragment = new Text2Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_text2, null, false);
        return inflate;
    }


}
