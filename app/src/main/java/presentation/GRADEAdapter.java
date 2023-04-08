package presentation;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.elevenlogin.R;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.GRADEBean;
import persistence.Utils.Student;

public class GRADEAdapter extends BaseQuickAdapter<GRADEBean, BaseViewHolder> {

    public GRADEAdapter() {
        super(R.layout.item_gpa);
    }

    @Override
    protected void convert(BaseViewHolder helper, GRADEBean bean) {
        helper.setText(R.id.tb1,bean.getTab1());
        helper.setText(R.id.tb2,bean.getTab2());
        helper.setText(R.id.tb3,bean.getTab3());
        helper.setText(R.id.tb5,bean.getTab5());
    }

}