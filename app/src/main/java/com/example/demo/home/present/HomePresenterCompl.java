package com.example.demo.home.present;

import com.example.demo.App;
import com.example.demo.home.model.HomeModel;
import com.example.demo.home.model.IHomeModel;
import com.example.demo.home.view.IHomeView;

public class HomePresenterCompl implements IHomePresenter {
    private IHomeView iHomeView;
    private IHomeModel iHomeModel;

    public HomePresenterCompl(IHomeView homeView) {
        this.iHomeView = homeView;
        iHomeModel = new HomeModel();
        iHomeModel.getDate(new HomeModel.IGetHomeLoadCallBack() {
            @Override
            public void getInspectionPresentResult(int persent, int toRepiredCount, int repiredCount) {
                iHomeView.showInspectionPresent(persent, toRepiredCount, repiredCount);
            }

            @Override
            public void getRepiredResult(int persent, int planRepair, int actualRepaired) {
                iHomeView.showRepired(persent, planRepair, actualRepaired);
            }

            @Override
            public void fail(String msg) {
                App.getContext().showToast(msg);
            }
        });
    }
}
