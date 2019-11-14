package com.example.demo.home.view;

public interface IHomeView {
    void showInspectionPresent(int persent, int toRepiredCount, int RepiredCount);

    void showRepired(int persent, int planRepair, int actualRepaired);
}
