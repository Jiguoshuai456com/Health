package com.wd.first.prenster;


import com.wd.common.Base.BasePresenter;
import com.wd.common.Base.IBaseView;

import com.wd.first.bean.ShiPinBean;
import com.wd.first.bean.ShiPinLeiMu;
import com.wd.first.bean.ShiPinPingLieBiao;
import com.wd.first.contract.HomePageContral;
import com.wd.first.moudle.HomePageModel;

public class HomePagePresenter extends BasePresenter implements HomePageContral.getPresenter {

    private HomePageModel homePageModel;

    public HomePagePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }


    @Override
    public void getLeiMu() {
        homePageModel.getLeiMu(new HomePageContral.getModel.CallBackLeiMu() {
            @Override
            public void getLeiMuSucc(ShiPinLeiMu shiPinLeiMu) {
                IBaseView iView = getView();
                if(iView instanceof HomePageContral.getView){
                    ((HomePageContral.getView)iView).getLeiMuSucc(shiPinLeiMu);
                }
            }

            @Override
            public void getLeiMuFiuld(String str) {
                IBaseView iView = getView();
                if(iView instanceof HomePageContral.getView){
                    ((HomePageContral.getView)iView).getLeiMuFiuld(str);
                }
            }
        });
    }

    @Override
    public void getShiPin(int categoryId, int page, int count) {
        homePageModel.getShiPin(categoryId, page, count, new HomePageContral.getModel.CallBackShiPin() {
            @Override
            public void getShiPinSucc(ShiPinBean shiPinBean) {
                IBaseView iView = getView();
                if(iView instanceof HomePageContral.getView){
                    ((HomePageContral.getView)iView).getShiPinSucc(shiPinBean);
                }
            }

            @Override
            public void getShiPinFiuld(String str) {
                IBaseView iView = getView();
                if(iView instanceof HomePageContral.getView){
                    ((HomePageContral.getView)iView).getShiPinFiuld(str);
                }
            }
        });
    }

    @Override
    public void getShiPinPingLieBiao(int videoId) {
        homePageModel.getShiPinPingLieBiao(videoId, new HomePageContral.getModel.CallBackShiPinPingLieBiao() {
            @Override
            public void getShiPinPingLieBiaoSucc(ShiPinPingLieBiao shiPinPingLieBiao) {
                IBaseView iView = getView();
                if(iView instanceof HomePageContral.getView){
                    ((HomePageContral.getView)iView).getShiPinPingLieBiaoSucc(shiPinPingLieBiao);
                }
            }

            @Override
            public void getShiPinPingLieBiaoFiuld(String str) {
                IBaseView iView = getView();
                if(iView instanceof HomePageContral.getView){
                    ((HomePageContral.getView)iView).getShiPinPingLieBiaoFiuld(str);
                }
            }
        });
    }

    @Override
    public void initModel() {
        homePageModel = new HomePageModel();
    }
}
