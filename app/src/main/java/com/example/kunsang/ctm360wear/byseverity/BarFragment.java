package com.example.kunsang.ctm360wear.byseverity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kunsang.ctm360wear.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import static org.eazegraph.lib.R.styleable.BarChart;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarFragment extends Fragment {


    public BarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar, container, false);
        BarChart mBarChart = (BarChart) view.findViewById(R.id.barchart);

        mBarChart.addBar(new BarModel("Pal", 200.f, Color.parseColor("#FE6DA8")));
        mBarChart.addBar(new BarModel("Padel", 255.f, Color.parseColor("#FE6DA8")));
        mBarChart.addBar(new BarModel("Padedfl", 333.3f, Color.parseColor("#FE6DA8")));
        mBarChart.addBar(new BarModel("Pdel", 10.f, Color.parseColor("#FE6DA8")));


        return view;
    }

}
