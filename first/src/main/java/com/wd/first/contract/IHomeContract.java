package com.wd.first.contract;

import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BannerBean;

public interface IHomeContract {
    interface IView extends IBaseView{
        void getBanner(BannerBean bannerBean);
    }
    interface IPrenster{
        void onBanner();
    }
    interface IMoudle{
        void onBanner(ICallBck iCallBck);
        interface ICallBck{
            void getBanner(BannerBean bannerBean);
        }
    }
}
