package com.wd.first.prenster;

import com.wd.common.Base.BasePresenter;
import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.DepartmenBean;
import com.wd.first.bean.DetailsBean;
import com.wd.first.bean.DrgusBean;
import com.wd.first.bean.LittleBean;
import com.wd.first.contract.DepartmenContraact;
import com.wd.first.moudle.DepartmenMoudle;

public class DepartmenPrenster extends BasePresenter implements DepartmenContraact.IPrenster {

    private DepartmenMoudle moudle;

    public DepartmenPrenster(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void onDepart() {
        moudle.onDepart(new DepartmenContraact.IMoudle.ICallBck() {
            @Override
            public void getDepart(DepartmenBean departmenBean) {
                IBaseView view = getView();
                if (view instanceof DepartmenContraact.IView){
                    DepartmenContraact.IView view1= (DepartmenContraact.IView) view;
                    view1.getDepart(departmenBean);
                }
            }
        });
    }

    @Override
    public void onBing(int id) {
        moudle.onBing(id, new DepartmenContraact.IMoudle.ICallBck2() {
            @Override
            public void getBing(BIngBean bIngBean) {
                IBaseView view = getView();
                if (view instanceof DepartmenContraact.IView){
                    DepartmenContraact.IView view1= (DepartmenContraact.IView) view;
                    view1.getBing(bIngBean);
                }
            }
        });
    }

    @Override
    public void onDetails(int id) {
        moudle.onDetails(id, new DepartmenContraact.IMoudle.ICallBck3() {
            @Override
            public void getDetails(DetailsBean detailsBean) {
                IBaseView view = getView();
                if (view instanceof DepartmenContraact.IView){
                    DepartmenContraact.IView view1= (DepartmenContraact.IView) view;
                    view1.getDetails(detailsBean);
                }
            }
        });
    }

    @Override
    public void onDrugs() {
        moudle.onDrugs(new DepartmenContraact.IMoudle.DrugICallBck() {
            @Override
            public void getDrgus(DrgusBean drgusBean) {
                IBaseView view = getView();
                if (view instanceof DepartmenContraact.IView){
                    DepartmenContraact.IView view1= (DepartmenContraact.IView) view;
                    view1.getDrgus(drgusBean);
                }
            }
        });

    }

    @Override
    public void onLittle(int id, int page, int count) {
        moudle.onLittle(id, page, count, new DepartmenContraact.IMoudle.DrugICallBck2() {
            @Override
            public void getLittle(LittleBean littleBean) {
                IBaseView view = getView();
                if (view instanceof DepartmenContraact.IView){
                    DepartmenContraact.IView view1= (DepartmenContraact.IView) view;
                    view1.getLittle(littleBean);
                }
            }
        });
    }

    @Override
    protected void initModel() {
        moudle = new DepartmenMoudle();
    }
}
