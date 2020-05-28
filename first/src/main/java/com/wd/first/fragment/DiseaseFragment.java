package com.wd.first.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wd.common.Base.BaseFragment;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.activity.DiseaseDetailsActivity;
import com.wd.first.adapter.BingAdapter;
import com.wd.first.adapter.DiseaseAdapter;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.DepartmenBean;
import com.wd.first.bean.DetailsBean;
import com.wd.first.bean.DrgusBean;
import com.wd.first.bean.DrgusDetailsBean;
import com.wd.first.bean.LittleBean;
import com.wd.first.contract.DepartmenContraact;
import com.wd.first.prenster.DepartmenPrenster;

import java.util.List;

import butterknife.BindView;

public class DiseaseFragment extends BaseFragment implements DepartmenContraact.IView {
    @BindView(R2.id.rv)
    RecyclerView rv;
    @BindView(R2.id.rv2)
    RecyclerView rv2;
    private String name;
    @Override
    protected BasePresenter initPresenter() {
        return new DepartmenPrenster(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.disease;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter instanceof DepartmenPrenster){
            DepartmenPrenster prenster= (DepartmenPrenster) presenter;
            prenster.onDepart();
        }
    }

    @Override
    public void getDepart(DepartmenBean departmenBean) {
        List<DepartmenBean.ResultBean> result = departmenBean.getResult();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        DiseaseAdapter adapter = new DiseaseAdapter(getActivity(), result);
        rv.setAdapter(adapter);
        adapter.setOnclickLinstener(new DiseaseAdapter.OnclickLinstener() {
            @Override
            public void OnClick(int postion) {
                int id = result.get(postion).getId();
                BasePresenter presenter = getPresenter();
                if (presenter instanceof DepartmenPrenster){
                    DepartmenPrenster prenster= (DepartmenPrenster) presenter;
                    prenster.onBing(id);
                }
            }
        });
    }

    @Override
    public void getBing(BIngBean bIngBean) {
            List<BIngBean.ResultBean> list = bIngBean.getResult();
            RecyclerView.LayoutManager layoutManager2= new GridLayoutManager(getActivity(),2);
            BingAdapter adapter = new BingAdapter(getActivity(), list);
            rv2.setLayoutManager(layoutManager2);
            rv2.setAdapter(adapter);
            adapter.setOnclickLinstener(new BingAdapter.OnclickLinstener() {



                @Override
                public void OnClick(int postion) {
                    int id = list.get(postion).getId();
                    BasePresenter presenter = getPresenter();
                    if (presenter instanceof DepartmenPrenster){
                        DepartmenPrenster prenster= (DepartmenPrenster) presenter;
                        prenster.onDetails(id);
                    }
                    name = list.get(postion).getName();
                }
            });
    }

    @Override
    public void getDetails(DetailsBean detailsBean) {
        if (detailsBean.getStatus().equals("0000")){
            Intent intent = new Intent(getActivity(), DiseaseDetailsActivity.class);
            intent.putExtra("detailsBean",detailsBean);
            intent.putExtra("name",name);
            startActivity(intent);
        }
    }

    @Override
    public void getDrgus(DrgusBean drgusBean) {

    }

    @Override
    public void getLittle(LittleBean littleBean) {

    }

    @Override
    public void getDrgusDetails(DrgusDetailsBean drgusDetailsBean) {

    }

}
