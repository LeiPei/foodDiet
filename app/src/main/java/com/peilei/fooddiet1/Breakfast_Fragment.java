package com.peilei.fooddiet1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by PeiLei on 10/23/16.
 */

public class Breakfast_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_breakfast, null);

        // when the user clicks the btn
        view.findViewById(R.id.btn_bf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "breakfast", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
