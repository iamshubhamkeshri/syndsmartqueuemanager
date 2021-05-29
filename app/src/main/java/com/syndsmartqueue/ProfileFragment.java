package com.syndsmartqueue;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        btn = (Button) rootView.findViewById(R.id.feedback);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(getActivity(), branchcleanessfeedback.class);
                startActivity(i);
            }
        });
        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}
