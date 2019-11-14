package com.example.demo.home.model;


import android.os.Handler;

public class HomeModel implements IHomeModel {

    @Override
    public void getDate(final IGetHomeLoadCallBack callBack) {
        //后期改为从数据库读
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.getInspectionPresentResult(90, 15, 3);
                    callBack.getRepiredResult(100, 30, 30);
                }
            }
        }, 1000);
    }

    public interface IGetHomeLoadCallBack {
        void getInspectionPresentResult(int persent, int toRepiredCount, int RepiredCount);

        void getRepiredResult(int persent, int planRepair, int actualRepaired);

        void fail(String msg);
    }

}
