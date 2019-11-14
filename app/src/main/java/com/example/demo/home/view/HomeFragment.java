package com.example.demo.home.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.demo.App;
import com.example.demo.R;
import com.example.demo.home.present.HomePresenterCompl;
import com.example.demo.home.present.IHomePresenter;

public class HomeFragment extends Fragment implements IHomeView, View.OnClickListener {
    private View parentView;

    private TextView inspection_record_percentage;
    private TextView to_repair_count;
    private TextView repaired_count;

    private TextView repired_percentage;
    private TextView plan_repair_count;
    private TextView actual_repaired_count;

    private IHomePresenter homePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return parentView;
    }

    private void initView() {
        parentView.findViewById(R.id.registration_documents).setOnClickListener(this);
        parentView.findViewById(R.id.maintenance).setOnClickListener(this);
        inspection_record_percentage = parentView.findViewById(R.id.inspection_record_percentage);
        to_repair_count = parentView.findViewById(R.id.to_repair_count);
        repaired_count = parentView.findViewById(R.id.repaired_count);
        repired_percentage = parentView.findViewById(R.id.repired_percentage);
        plan_repair_count = parentView.findViewById(R.id.plan_repair_count);
        actual_repaired_count = parentView.findViewById(R.id.actual_repaired_count);

        homePresenter = new HomePresenterCompl(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registration_documents://文件登记
                break;
            case R.id.maintenance://维护中
                App.getContext().showToast("功能维护中...");
                break;
        }
    }


    @Override
    public void showInspectionPresent(int persent, int toRepiredCount, int RepiredCount) {
        inspection_record_percentage.setText(persent + "%");
        to_repair_count.setText("报修：" + to_repair_count);
        repaired_count.setText("修复：" + repaired_count);
    }

    @Override
    public void showRepired(int persent, int planRepair, int actualRepaired) {
        repired_percentage.setText(persent + "%");
        plan_repair_count.setText("计划检修:" + planRepair);
        actual_repaired_count.setText("实际检修:" + actualRepaired);
    }
}
