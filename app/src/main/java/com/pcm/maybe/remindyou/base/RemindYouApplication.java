package com.pcm.maybe.remindyou.base;

import android.app.Application;

import com.pcm.maybe.remindyou.utils.ToastUtils;

/**
 * Created by maybe on 2017/3/24.
 */

public class RemindYouApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化吐司工具类
        ToastUtils.init(this);
    }
}
