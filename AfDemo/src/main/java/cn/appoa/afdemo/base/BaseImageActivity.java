package cn.appoa.afdemo.base;

import com.wangzhen.statusbar.DarkStatusBar;

import cn.appoa.afbase.presenter.BasePresenter;
import cn.appoa.afimage.activity.AfImageActivity;
import cn.appoa.afutils.res.ScreenUtils;

/**
 * 带上传图片的Activity基类
 *
 * @param <P>
 */
public abstract class BaseImageActivity<P extends BasePresenter> extends AfImageActivity<P> {

    @Override
    public void initView() {
        //深色状态栏
        DarkStatusBar.get().fitDark(this);
        //沉浸式
        ScreenUtils.setPaddingTop(titlebar);
    }

    @Override
    public boolean enableSliding() {
        //开启侧滑返回
        return true;
    }

}
