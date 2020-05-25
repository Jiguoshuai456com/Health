package com.wd.first.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wd.common.Base.BaseFragment;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.adapter.BingAdapter;
import com.wd.first.adapter.DiseaseAdapter;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.DepartmenBean;
import com.wd.first.contract.DepartmenContraact;
import com.wd.first.prenster.DepartmenPrenster;

import java.util.List;

import butterknife.BindView;

public class DiseaseFragment extends BaseFragment implements DepartmenContraact.IView {
    @BindView(R2.id.rv)
    RecyclerView rv;
    @BindView(R2.id.rv2)
    RecyclerView rv2;
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
            List<BIngBean.ResultBean> result = bIngBean.getResult();
            RecyclerView.LayoutManager layoutManager2= new GridLayoutManager(getActivity(),2);
            BingAdapter adapter = new BingAdapter(getActivity(), result);
            rv2.setLayoutManager(layoutManager2);
            rv2.setAdapter(adapter);


    }

}
