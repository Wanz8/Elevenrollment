package presentation;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.elevenlogin.R;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.Student;

public class LookCalendarAdapter extends BaseQuickAdapter<Student, BaseViewHolder> {

    List<String> list = new ArrayList<>();
    public LookCalendarAdapter(List<String> list) {
        super(R.layout.item_course_calendar);
        this.list=list;
    }

    @Override
    protected void convert(BaseViewHolder helper, Student bean) {
        helper.setText(R.id.title,bean.getStudentName());
        helper.setText(R.id.name,bean.getStudentAddress());
        helper.setText(R.id.time,list.get(helper.getLayoutPosition()));
    }

}