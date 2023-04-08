package presentation;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.elevenlogin.R;

import persistence.Utils.Course;

public class CourseAdapter extends BaseQuickAdapter<Course, BaseViewHolder> {

    public CourseAdapter() {
        super(R.layout.item_course);
    }

    @Override
    protected void convert(BaseViewHolder helper, Course bean) {
helper.setText(R.id.name,bean.getCourseID()+"\n"+bean.getCourseName());

    }

}