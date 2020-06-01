package com.wd.first.contract;

import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.NewsBean;

public interface IHomeContract {
    interface IView extends IBaseView{
        void getBanner(BannerBean bannerBean);
        void getNews(NewsBean newsBean);
    }
    interface IPrenster{
        void onBanner();
        void onNews(int plateId,int page,int count);
    }
    interface IMoudle{
        void onBanner(ICallBck iCallBck);
        void onNews(int plateId,int page,int count,ICallBack2 iCallBack2);
        interface ICallBck{
            void getBanner(BannerBean bannerBean);
        }
        interface ICallBack2{
            void getNews(NewsBean newsBean);
        }
    }
}
