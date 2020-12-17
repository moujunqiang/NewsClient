package com.example.newsclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newsclient.adapter.ImageTextAdapter;
import com.example.newsclient.bean.ImageTextView;

import java.util.ArrayList;
import java.util.List;

public class TextFragment extends Fragment {

    private View inflate;


    public static TextFragment newInstance() {

        Bundle args = new Bundle();

        TextFragment fragment = new TextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_text, null, false);
        return inflate;
    }


}
