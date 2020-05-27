package com.wd.first.contract;

import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.DepartmenBean;
import com.wd.first.bean.DetailsBean;
import com.wd.first.bean.DrgusBean;
import com.wd.first.bean.LittleBean;

public interface DepartmenContraact {
    interface IView extends IBaseView {
        void getDepart(DepartmenBean departmenBean);
        void getBing(BIngBean bIngBean);
        void getDetails(DetailsBean detailsBean);
        void getDrgus(DrgusBean drgusBean);
        void getLittle(LittleBean littleBean);
    }
    interface IPrenster{
        void onDepart();
        void onBing(int id);
        void onDetails(int id);
        void onDrugs();
        void onLittle(int id,int page,int count);
    }
    interface IMoudle{
        void onDepart(ICallBck iCallBck);
        void onBing(int id,ICallBck2 iCallBck2);
        void onDetails(int id,ICallBck3 iCallBck3);
        void onDrugs(DrugICallBck drugICallBck);
        void onLittle(int id,int page,int count,DrugICallBck2 drugICallBck2);
        interface ICallBck{
            void getDepart(DepartmenBean departmenBean);
        }
        interface ICallBck2{
            void getBing(BIngBean bIngBean);
        }
        interface ICallBck3{
            void getDetails(DetailsBean detailsBean);
        }
        interface DrugICallBck{
            void getDrgus(DrgusBean drgusBean);
        }
        interface DrugICallBck2{
            void getLittle(LittleBean littleBean);
        }
    }
}
