package cn.appoa.afdemo.activity.utils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.appoa.afbase.titlebar.BaseTitlebar;
import cn.appoa.afdemo.R;
import cn.appoa.afdemo.base.BaseActivity;
import cn.appoa.afui.titlebar.DefaultTitlebar;
import cn.appoa.afutils.encrypt.Md5Utils;
import cn.appoa.afutils.res.PhoneUtils;
import cn.appoa.afutils.res.ViewUtils;
import cn.appoa.afutils.toast.ToastUtils;

/**
 * Md5加密工具类
 */
public class Md5UtilsActivity extends BaseActivity
        implements View.OnClickListener {

    @Override
    public BaseTitlebar initTitlebar() {
        return new DefaultTitlebar.Builder(this)
                .setTitle("Md5Utils")
                .setBackImage(R.drawable.back_black)
                .create();
    }

    @Override
    public void initContent(Bundle savedInstanceState) {
        setContent(R.layout.activity_md5_utils);
    }

    private EditText et_login_phone;
    private Button btn_encrypt_32;
    private Button btn_encrypt_16;
    private Button btn_encrypt_phone;
    private TextView tv_result;

    @Override
    public void initView() {
        super.initView();
        et_login_phone = (EditText) findViewById(R.id.et_login_phone);
        btn_encrypt_32 = (Button) findViewById(R.id.btn_encrypt_32);
        btn_encrypt_16 = (Button) findViewById(R.id.btn_encrypt_16);
        btn_encrypt_phone = (Button) findViewById(R.id.btn_encrypt_phone);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void initData() {
        btn_encrypt_32.setOnClickListener(this);
        btn_encrypt_16.setOnClickListener(this);
        btn_encrypt_phone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (ViewUtils.isTextEmpty(et_login_phone)) {
            ToastUtils.showShort(mActivity, et_login_phone.getHint(), false);
            return;
        }
        String phone = ViewUtils.getText(et_login_phone);
        if (!PhoneUtils.isMobile(phone)) {
            ToastUtils.showShort(mActivity, "请输入正确的手机号", false);
            return;
        }
        String result = "";
        switch (v.getId()) {
            case R.id.btn_encrypt_32:
                result = Md5Utils.GetMD5Code32(phone);
                break;
            case R.id.btn_encrypt_16:
                result = Md5Utils.GetMD5Code16(phone);
                break;
            case R.id.btn_encrypt_phone:
                result = Md5Utils.getSmsToken(phone);
                break;
        }
        tv_result.setText(result);
    }

}
