package com.pcm.maybe.remindyou;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pcm.maybe.remindyou.base.MyBaseActivity;
import com.pcm.maybe.remindyou.ui.drinkremind.DrinkRemindFragment;
import com.pcm.maybe.remindyou.ui.map.MapFragment;
import com.pcm.maybe.remindyou.ui.remind.RemindFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 主界面，viewpager嵌套Fragment展示三个界面
 */
public class MainActivity extends MyBaseActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.ivRemind_normal)
    ImageView ivRemindNormal;
    @BindView(R.id.tvRemind_normal)
    TextView tvRemindNormal;
    @BindView(R.id.ivRemind_selected)
    ImageView ivRemindSelected;
    @BindView(R.id.tvRemind_selected)
    TextView tvRemindSelected;
    @BindView(R.id.relative_remind)
    RelativeLayout relativeRemind;
    @BindView(R.id.ivDrink_normal)
    ImageView ivDrinkNormal;
    @BindView(R.id.tvDrink_normal)
    TextView tvDrinkNormal;
    @BindView(R.id.ivDrink_selected)
    ImageView ivDrinkSelected;
    @BindView(R.id.tvDrink_selected)
    TextView tvDrinkSelected;
    @BindView(R.id.relative_drink)
    RelativeLayout relativeDrink;
    @BindView(R.id.ivMap_normal)
    ImageView ivMapNormal;
    @BindView(R.id.tvMap_normal)
    TextView tvMapNormal;
    @BindView(R.id.ivMap_selected)
    ImageView ivMapSelected;
    @BindView(R.id.tvMap_selected)
    TextView tvMapSelected;
    @BindView(R.id.relative_map)
    RelativeLayout relativeMap;
    @BindView(R.id.ll_main_bottom)
    LinearLayout llMainBottom;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;


    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;
    @BindView(R.id.viewpagerMain)
    ViewPager viewpagerMain;
    private Unbinder mUnbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mainToolbar);

        initView();
    }


    private void initView() {
        mUnbinder = ButterKnife.bind(this);
        viewpagerMain = (ViewPager) findViewById(R.id.viewpagerMain);
        viewpagerMain.setAdapter(adapter);
        viewpagerMain.addOnPageChangeListener(this);

        //默认选中第一个
        setTransparency();
        ivRemindSelected.setImageAlpha(255);
        tvRemindSelected.setTextColor(Color.argb(255,69,192,26));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    //viewpager适配器
    private FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    //跳转到备忘录的Fragment
                    return new RemindFragment();
                case 1:
                    //显示喝水提醒的Fragment
                    return new DrinkRemindFragment();
                case 2:
                    //显示地图的Fragment
                    return new MapFragment();
                default:
                    throw new RuntimeException("未知错误");
            }
        }

        //一共三页
        @Override
        public int getCount() {
            return 3;
        }
    };


    //viewpager滑动监听
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //根据ViewPager滑动位置更改透明度=
        int diaphaneity_one= (int) (255*positionOffset);
        int diaphaneity_two= (int) (255*(1-positionOffset));
        switch (position){
            case 0:
                ivRemindNormal.setImageAlpha(diaphaneity_one);
                ivRemindSelected.setImageAlpha(diaphaneity_two);
                ivDrinkNormal.setImageAlpha(diaphaneity_two);
                ivDrinkSelected.setImageAlpha(diaphaneity_one);

                tvRemindNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                tvRemindSelected.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                tvDrinkNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                tvDrinkSelected.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                break;
            case 1:
                ivDrinkNormal.setImageAlpha(diaphaneity_one);
                ivDrinkSelected.setImageAlpha(diaphaneity_two);
                ivMapNormal.setImageAlpha(diaphaneity_two);
                ivMapSelected.setImageAlpha(diaphaneity_one);

                tvDrinkNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                tvDrinkSelected.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                tvMapNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                tvMapSelected.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                break;

        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick({R.id.relative_remind,R.id.relative_drink,R.id.relative_map})
    public void MyClick(View view){
        setTransparency();
        switch (view.getId()){
            case R.id.relative_remind:
                viewpagerMain.setCurrentItem(0,false);
                ivRemindSelected.setImageAlpha(255);
                tvRemindSelected.setTextColor(Color.argb(255,69,192,26));
                break;

            case R.id.relative_drink:
                viewpagerMain.setCurrentItem(1,false);
                ivDrinkSelected.setImageAlpha(255);
                tvDrinkSelected.setTextColor(Color.argb(255,69,192,26));
                break;

            case R.id.relative_map:
                viewpagerMain.setCurrentItem(2,false);
                ivMapSelected.setImageAlpha(255);
                tvMapSelected.setTextColor(Color.argb(255,69,192,26));
                break;
        }
    }

    /**
     * 把选中的图片、文字全部隐藏（设置透明度）
     */
    private void setTransparency(){
        ivRemindNormal.setImageAlpha(255);
        ivDrinkNormal.setImageAlpha(255);
        ivMapNormal.setImageAlpha(255);
        //透明
        ivRemindSelected.setImageAlpha(1);
        ivDrinkSelected.setImageAlpha(1);
        ivMapSelected.setImageAlpha(1);

        tvRemindNormal.setTextColor(Color.argb(255,153,153,153));
        tvDrinkNormal.setTextColor(Color.argb(255,153,153,153));
        tvMapNormal.setTextColor(Color.argb(255,153,153,153));

        tvRemindSelected.setTextColor(Color.argb(0,69,192,26));
        tvDrinkSelected.setTextColor(Color.argb(0,69,192,26));
        tvMapSelected.setTextColor(Color.argb(0,69,192,26));
    }
}
