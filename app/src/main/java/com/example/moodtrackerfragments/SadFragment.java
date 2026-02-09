package com.example.moodtrackerfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class SadFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sad, container, false);

        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("name");
            TextView tv = view.findViewById(R.id.tvMessage);

            if (tv != null && name != null && !name.isEmpty()) {
                tv.setText(name + ", הכל יהיה טוב");
            }
        }

        return view;
    }
}