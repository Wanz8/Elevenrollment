package presentation;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.elevenlogin.R;

import persistence.Utils.Student;

public class LookCourseAdapter extends BaseQuickAdapter<Student, BaseViewHolder> {

    public LookCourseAdapter() {
        super(R.layout.item_course);
    }

    @Override
    protected void convert(BaseViewHolder helper, Student bean) {
        helper.setText(R.id.name, bean.getStudentName() + "\n" + bean.getStudentAddress());

    }

}