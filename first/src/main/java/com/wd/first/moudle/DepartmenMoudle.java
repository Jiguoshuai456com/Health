package com.wd.first.moudle;

import com.wd.common.utiuls.NetUtils;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.DepartmenBean;
import com.wd.first.bean.DetailsBean;
import com.wd.first.bean.DrgusBean;
import com.wd.first.bean.LittleBean;
import com.wd.first.contract.DepartmenContraact;
import com.wd.first.contract.FirstApis;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DepartmenMoudle implements DepartmenContraact.IMoudle {
    @Override
    public void onDepart(ICallBck iCallBck) {
        createrRetrofit().getDepart().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DepartmenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DepartmenBean departmenBean) {
                        if (iCallBck!=null)
                            iCallBck.getDepart(departmenBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onBing(int id, ICallBck2 iCallBck2) {
        createrRetrofit().getBing(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BIngBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BIngBean bIngBean) {
                        if (iCallBck2!=null)
                            iCallBck2.getBing(bIngBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDetails(int id,ICallBck3 iCallBck3) {
        createrRetrofit().getDetails(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        if (iCallBck3!=null)
                            iCallBck3.getDetails(detailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDrugs(DrugICallBck drugICallBck) {
        createrRetrofit().getDrugs().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DrgusBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DrgusBean drgusBean) {
                        if (drugICallBck!=null)
                            drugICallBck.getDrgus(drgusBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onLittle(int id, int page, int count, DrugICallBck2 drugICallBck2) {
        createrRetrofit().getLittle(id,page,count).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LittleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LittleBean littleBean) {
                        if (drugICallBck2!=null)
                            drugICallBck2.getLittle(littleBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static FirstApis createrRetrofit(){
        return NetUtils.getInstance().getRetrofitServie(FirstApis.class);
    }
}
