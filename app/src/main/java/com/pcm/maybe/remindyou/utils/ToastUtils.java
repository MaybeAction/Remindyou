package com.pcm.maybe.remindyou.utils;

import android.content.Context;
import android.support.annotation.UiThread;
import android.widget.Toast;

/**
 * 显示Toast的工具类，所有方法都必须在UI线程调用
 * 需要在应用入口初始化
 */

@UiThread
public class ToastUtils {
    private static Toast toast;
    private static Context context;

    public static void init(Context context){
        ToastUtils.context=context.getApplicationContext();
    }

    public static void showShort(String str){
        if (toast == null) {
            toast=Toast.makeText(context,str,Toast.LENGTH_SHORT);
        }else{
            toast.setText(str);
        }

        toast.show();
    }

    public static void showShort(int resId){
        showShort(context.getResources().getString(resId));
    }
}
