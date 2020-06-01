package com.wd.first.prenster;

import com.wd.common.Base.BasePresenter;
import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.NewsBean;
import com.wd.first.contract.IHomeContract;
import com.wd.first.moudle.IHomeMoudle;

public class IHomePrenster extends BasePresenter implements IHomeContract.IPrenster {

    private IHomeMoudle moudle;

    public IHomePrenster(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        moudle = new IHomeMoudle();
    }

    @Override
    public void onBanner() {
        moudle.onBanner(new IHomeContract.IMoudle.ICallBck() {
            @Override
            public void getBanner(BannerBean bannerBean) {
                IBaseView view = getView();
                if (view instanceof IHomeContract.IView){
                    IHomeContract.IView view1= (IHomeContract.IView) view;
                    view1.getBanner(bannerBean);
                }
            }
        });
    }

    @Override
    public void onNews(int plateId, int page, int count) {
        moudle.onNews(plateId, page, count, new IHomeContract.IMoudle.ICallBack2() {
            @Override
            public void getNews(NewsBean newsBean) {
                IBaseView view = getView();
                if (view instanceof IHomeContract.IView){
                    IHomeContract.IView view1= (IHomeContract.IView) view;
                    view1.getNews(newsBean);
                }
            }
        });
    }
}
