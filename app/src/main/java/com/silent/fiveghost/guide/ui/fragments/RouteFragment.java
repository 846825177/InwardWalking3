package com.silent.fiveghost.guide.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.RouteAdapter;
import com.silent.fiveghost.guide.ui.activitys.RouteDetailsActivity;

/**
 * Created by 84682 on 2018/1/27.
 */

public class RouteFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mHomeListView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RouteAdapter routeAdapter = new RouteAdapter(getActivity());
        mRecyclerView.setAdapter(routeAdapter);
        routeAdapter.setOnClickListener(new RouteAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                startActivity(new Intent(getActivity(), RouteDetailsActivity.class));
            }
        });
    }
}
