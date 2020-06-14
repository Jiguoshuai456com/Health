package com.wd.first.contract;

import com.wd.common.Base.IBaseView;

import com.wd.first.bean.ShiPinBean;
import com.wd.first.bean.ShiPinLeiMu;
import com.wd.first.bean.ShiPinPingLieBiao;

public class HomePageContral  {
    public interface getView extends IBaseView {
         void getLeiMuSucc(ShiPinLeiMu shiPinLeiMu);
         void getLeiMuFiuld(String str);

         void getShiPinSucc(ShiPinBean shiPinBean);
         void getShiPinFiuld(String str);

         void getShiPinPingLieBiaoSucc(ShiPinPingLieBiao shiPinPingLieBiao);
         void getShiPinPingLieBiaoFiuld(String str);
    }
    public interface getPresenter{
        void getLeiMu();
        void getShiPin(int categoryId, int page, int count);
        void getShiPinPingLieBiao(int videoId);
    }
    public interface getModel{
        void getLeiMu(CallBackLeiMu callBackLeiMu);
        interface CallBackLeiMu{
            void getLeiMuSucc(ShiPinLeiMu shiPinLeiMu);
            void getLeiMuFiuld(String str);
        }
        void getShiPin(int categoryId, int page, int count, CallBackShiPin callBackShiPin);
        interface CallBackShiPin{
            void getShiPinSucc(ShiPinBean shiPinBean);
            void getShiPinFiuld(String str);
        }
        void getShiPinPingLieBiao(int videoId, CallBackShiPinPingLieBiao callBackShiPinPingLieBiao);
         interface CallBackShiPinPingLieBiao{
             void getShiPinPingLieBiaoSucc(ShiPinPingLieBiao shiPinPingLieBiao);
             void getShiPinPingLieBiaoFiuld(String str);
        }
    }
}
