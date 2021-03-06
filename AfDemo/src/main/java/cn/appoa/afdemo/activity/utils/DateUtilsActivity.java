package cn.appoa.afdemo.activity.utils;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import cn.appoa.afbase.titlebar.BaseTitlebar;
import cn.appoa.afdemo.R;
import cn.appoa.afdemo.base.BaseActivity;
import cn.appoa.afui.titlebar.DefaultTitlebar;
import cn.appoa.afutils.date.DateUtils;

/**
 * 时间格式化
 */
public class DateUtilsActivity extends BaseActivity {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this)
                .setTitle("DateUtils")
                .setBackImage(R.drawable.back_black)
                .create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_date_utils);
    }

    private TextView tv_time2_1;
    private TextView tv_time2_2;
    private TextView tv_time2_3;
    private TextView tv_time2_4;
    private TextView tv_time2_5;
    private TextView tv_time2_6;

    @Override
    public void initView() {
        super.initView();
        tv_time2_1 = (TextView) findViewById(R.id.tv_time2_1);
        tv_time2_2 = (TextView) findViewById(R.id.tv_time2_2);
        tv_time2_3 = (TextView) findViewById(R.id.tv_time2_3);
        tv_time2_4 = (TextView) findViewById(R.id.tv_time2_4);
        tv_time2_5 = (TextView) findViewById(R.id.tv_time2_5);
        tv_time2_6 = (TextView) findViewById(R.id.tv_time2_6);
    }

    @Override
    public void initData() {
        Calendar calendar = Calendar.getInstance();
        //几秒前
        calendar.add(Calendar.SECOND, -10);
        tv_time2_1.setText(DateUtils.getTimestampString(calendar.getTime()));
        //几分钟前
        calendar.add(Calendar.MINUTE, -5);
        tv_time2_2.setText(DateUtils.getTimestampString(calendar.getTime()));
        //几小时前
        calendar.add(Calendar.HOUR_OF_DAY, -3);
        tv_time2_3.setText(DateUtils.getTimestampString(calendar.getTime()));
        //昨天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        tv_time2_4.setText(DateUtils.getTimestampString(calendar.getTime()));
        //前天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        tv_time2_5.setText(DateUtils.getTimestampString(calendar.getTime()));
        //更早
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        tv_time2_6.setText(DateUtils.getTimestampString(calendar.getTime()));
    }

}
