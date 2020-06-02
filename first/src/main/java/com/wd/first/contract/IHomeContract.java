package com.wd.first.contract;

import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.DetailsBean;
import com.wd.first.bean.NewsBean;
import com.wd.first.bean.NewsDetailsBean;

public interface IHomeContract {
    interface IView extends IBaseView{
        void getBanner(BannerBean bannerBean);
        void getNews(NewsBean newsBean);
        void getNewsDetails(NewsDetailsBean newsDetailsBean);
    }
    interface IPrenster{
        void onBanner();
        void onNews(int plateId,int page,int count);
        void onNewsDetails(int infoId);
    }
    interface IMoudle{
        void onBanner(ICallBck iCallBck);
        void onNews(int plateId,int page,int count,ICallBack2 iCallBack2);
        void onNewsDetails(int infoId,ICallBack3 iCallBack3);
        interface ICallBck{
            void getBanner(BannerBean bannerBean);
        }
        interface ICallBack2{
            void getNews(NewsBean newsBean);
        }
        interface ICallBack3{
            void getNewsDetails(NewsDetailsBean newsDetailsBean);
        }
    }
}
