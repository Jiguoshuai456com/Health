package com.wd.first.contract;

import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.DepartmenBean;

public interface DepartmenContraact {
    interface IView extends IBaseView {
        void getDepart(DepartmenBean departmenBean);
        void getBing(BIngBean bIngBean);
    }
    interface IPrenster{
        void onDepart();
        void onBing(int id);
    }
    interface IMoudle{
        void onDepart(ICallBck iCallBck);
        void onBing(int id,ICallBck2 iCallBck2);
        interface ICallBck{
            void getDepart(DepartmenBean departmenBean);
        }
        interface ICallBck2{
            void getBing(BIngBean bIngBean);
        }
    }
}
