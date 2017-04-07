package com.pcm.maybe.remindyou.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.pcm.maybe.remindyou.R;
import com.pcm.maybe.remindyou.utils.ToastUtils;

public class MyBaseActivity extends AppCompatActivity {
    private static final String INTENT_BUNDLE="IntentWithBundle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //跳转
    protected void toClass(Class cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }
    //跳转并传Bundle对象
    protected void toClass(Class cls,Bundle bundle){
        Intent intent=new Intent(this,cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }else{
            Log.d(INTENT_BUNDLE,"Bundle is null");
        }
        startActivity(intent);
    }

    //需要返回值得跳转
    protected void toClassForResult(Class cls,Bundle bundle,int requestCode){
        Intent intent=new Intent(this,cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }else{
            Log.d(INTENT_BUNDLE,"Bundle is null");
        }

        startActivityForResult(intent,requestCode);
    }


}
