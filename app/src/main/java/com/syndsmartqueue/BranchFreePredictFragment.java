package com.syndsmartqueue;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class BranchFreePredictFragment extends Fragment {
    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //This Fragment has Dummy Data for now, on production level Data will be fetched from server algorithms
        return inflater.inflate(R.layout.fragment_branch_free_predict, null);
    }
}