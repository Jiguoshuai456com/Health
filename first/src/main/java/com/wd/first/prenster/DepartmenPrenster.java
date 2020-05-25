package com.wd.first.prenster;

import com.wd.common.Base.BasePresenter;
import com.wd.common.Base.IBaseView;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.DepartmenBean;
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
    protected void initModel() {
        moudle = new DepartmenMoudle();
    }
}
