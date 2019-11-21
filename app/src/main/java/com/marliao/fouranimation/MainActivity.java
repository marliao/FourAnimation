package com.marliao.fouranimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private ImageView ivPicture;
    private Button btnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btnMore = (Button) findViewById(R.id.btn_more);
        ivPicture = (ImageView) findViewById(R.id.iv_picture);
        //给按钮添加点击事件
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                /**
                 *
                 * 一.平移动画TranslateAnimation
                 * 1.XML实现方式（res/anim，没有此文件夹自己建立）：
                 * <?xml version="1.0" encoding="utf-8"?> <translate xmlns:android="http://schemas.android.com/apk/res/android"
                 *     android:duration="1000"
                 *     android:fromXDelta="0"
                 *     android:fromYDelta="0"
                 *     android:repeatCount="infinite"
                 *     android:repeatMode="reverse"
                 *     android:toXDelta="50%p"/>
                 *
                 *     使用： Animation tran = AnimationUtils.loadAnimation(this,R.anim.translate);
                 *     translate.startAnimation(tran);
                 *
                 *属性说明：
                 * android:fromXDelta，平移的起点x方向坐标（android:toXDelta和Y方向的同理）：
                 * 1.如果值是数值类型，即20或者25.0之类的，譬如50表示以当前View左上角坐标加50px为初始点；
                 * 2.如果值是百分比类型，即20%或者50%之类的，50%表示以当前View的左上角加上当前View宽高的50%做为初始点；
                 * 3.如果是父值的类型，即-100%p或者100%p之类的，50%p表示以当前View的左上角加上父控件宽高的50%做为初始点；
                 *
                 * 2.代码实现方式：
                 * 8个参数依次：起点x的坐标参照，起点x的坐标值，终点x的坐标参照，终点x的坐标值，起点y的坐标参照，起点y的坐标值，终点y的坐标参照，终点y的坐标值；
                 * 坐标参照是用来设置位置的，比如：
                 * RELATIVE_TO_PARENT（XML中父值的类型）：相当于用XML时的“android:toXDelta=”50%p”中的p，表示以父控件为参照，1代表100%p，0.5代表50%p，Y方向同理；
                 * RELATIVE_TO_SELF（XML中百分比类型）：相当于XML时的“android:toXDelta=”50%”，以自身为参照，1相当于XML中的100%，0.5相当于XML中的50%，Y方向同理；
                 * ABSOLUTE（XML中数值类型）：相当于XML中的“android:toXDelta=”50”；
                 * 即三种参数其实跟XML中的使用方式是对应的，如果不懂看XML方式来理解就懂了。
                 * 如果在代码中不写坐标参照即只有4个参数值，默认是ABSOLUTE方式。
                 */
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
                translateAnimation.setDuration(2000);
                ivPicture.startAnimation(translateAnimation);
                break;
            case R.id.btn_2:
                /**
                 * 二：缩放动画
                 * 1.XML实现方式：
                 *
                 * <?xml version="1.0" encoding="utf-8"?>
                 * <scale xmlns:android="http://schemas.android.com/apk/res/android"
                 *     android:duration="1000"
                 *     android:fromXScale="1.0"
                 *     android:fromYScale="1.0"
                 *     android:pivotX="50%"
                 *     android:pivotY="50%"
                 *     android:repeatCount="infinite"
                 *     android:repeatMode="reverse"
                 *     android:toXScale="50%p"
                 *     android:toYScale="50%p" />
                 * 使用：
                 * Animation scaleAn = AnimationUtils.loadAnimation(this,R.anim.scale);
                 * scale.startAnimation(scaleAn);
                 *
                 * android:fromXScale，缩放开始时的x方向大小；
                 * android:fromYScale，缩放开始时的y方向大小；
                 * android:pivotX，缩放的中心的x坐标（即以某个点为中心进行缩放）；
                 * 以上3个属性y方向的同理。
                 * android:fromXScale和android:toXScale，还有Y方向的属性值也有三种形式（以android:fromXScale举例）：
                 * 1.如果值是数值类型，即1或者2之类的表示缩放动画开始时的宽是自身宽的1或者2倍；
                 * 2.如果值是百分比类型，即20%或者50%之类的，表示缩放动画开始时的宽是自身宽的20%或者50%；
                 * 3.如果是父值类型，即50%p或者100%p之类的，表示缩放动画开始时的宽是父控件宽的50%或者100%；
                 * android:pivotX的属性值有两种形式：
                 * 1.如果值是百分比类型，即20%或者50%之类的，表示缩放的中心点x坐标在自身左上角坐标+自身宽度的20%或者50%处；
                 * 2.如果是父值类型，即50%p或者100%p之类的，表示缩放的中心点x坐标在自身左上角坐标+父控件宽度的50%或者100%处；
                 * 补充：如果是数值类型，比如1或者2，无效，无论是多少，都表示缩放的中心点是自身的左上角。
                 * 2.代码实现方式：
                 *
                 * 8个参数依次：起始宽度，结束宽度，缩放起始高度，结束高度，缩放中心点x方向的坐标参照，缩放中心点的x坐标，缩放中心点y方向的坐标参照，缩放中心点的y坐标；
                 * 前4个参数只能是float格式，效果都是自身宽高的倍数，比如例子中表示，起始宽度是自身宽度1倍，结束宽度是自身一半；
                 * 后面4个参数中三种写法：
                 * Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f,表示中心点是自身左上角坐标+父控件宽高的一半；
                 * Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f，表示中心点是自身左上角坐标+自身宽高的一半；
                 * Animation.ABSOLUTE,100,Animation.ABSOLUTE,100，表示中心点是自身左上角坐标+100；
                 */
                ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(2000);
                ivPicture.startAnimation(scaleAnimation);
                break;
            case R.id.btn_3:
                /**
                 * 三.透明动画
                 * 1.XML实现方式：
                 *
                 * <?xml version="1.0" encoding="utf-8"?>
                 * <alpha xmlns:android="http://schemas.android.com/apk/res/android"
                 *     android:duration="1000"
                 *     android:fromAlpha="1"
                 *     android:repeatCount="-1"
                 *     android:repeatMode="reverse"
                 *     android:toAlpha="0.5">
                 *
                 * </alpha>

                 * android:fromAlpha和android:toAlpha分别表示开始和结束时的透明度，值只有一种格式，0-1之间的数，1表示不透明，0表示完全透明，这个比较简单。
                 * 2.代码中设置：
                 * 透明动画比较简单，两个参数，一个是开始的透明度，一个是结束的透明度，值与在XML中写的格式相同。
                 */
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(2000);
                ivPicture.startAnimation(alphaAnimation);
                break;
            case R.id.btn_4:
                /**
                 * 四，旋转动画
                 * 1.XML实现方式：
                 *
                 * <?xml version="1.0" encoding="utf-8"?>
                 * <rotate xmlns:android="http://schemas.android.com/apk/res/android"
                 *     android:duration="1000"
                 *     android:fromDegrees="0"
                 *     android:pivotX="50%"
                 *     android:pivotY="50%"
                 *     android:repeatCount="infinite"
                 *     android:repeatMode="reverse"
                 *     android:toDegrees="-90"></rotate>
                 *
                 * android:fromDegrees和android:toDegrees分别表示起始和结束的角度，值只能是一种格式，数值类型，可以说int也可以是float，代表角度.
                 * 前两个参数表示开始角度和结束角度，没啥好说的。
                 * 后面4个参数中三种写法：
                 * Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f,表示旋转中心点是自身左上角坐标+父控件宽高的一半；
                 * Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f，表示旋转中心点是自身左上角坐标+自身宽高的一半；
                 * Animation.ABSOLUTE,100,Animation.ABSOLUTE,100，表示旋转中心点是自身左上角坐标+100；
                 */
                RotateAnimation rotateAnimation = new RotateAnimation(90, -90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(2000);
                ivPicture.startAnimation(rotateAnimation);
                break;
            case R.id.btn_more:
                /**
                 * 最后，汇总：上面四种动画都是单独使用的，我们如果想混合使用，比如变大的同时变透明，那就得组合动画了，组合动画也是一样的可以XML也可以代码写：
                 * 1.XML实现方式：
                 *
                 * <?xml version="1.0" encoding="utf-8"?>
                 * <set xmlns:android="http://schemas.android.com/apk/res/android"
                 *     android:fillAfter="true"
                 *     android:interpolator="@android:anim/cycle_interpolator"
                 *     android:shareInterpolator="true">
                 *     <translate
                 *         android:duration="1000"
                 *         android:fromXDelta="0"
                 *         android:fromYDelta="0"
                 *         android:toXDelta="50%p"
                 *         android:toYDelta="0" />
                 *
                 *     <alpha
                 *         android:duration="1000"
                 *         android:fromAlpha="1"
                 *         android:repeatCount="1"
                 *         android:repeatMode="reverse"
                 *         android:toAlpha="0.5" />
                 *
                 *     <scale
                 *         android:fromXScale="1"
                 *         android:fromYScale="0.5"
                 *         android:pivotX="50%"
                 *         android:pivotY="50%"
                 *         android:repeatCount="1"
                 *         android:repeatMode="reverse"
                 *         android:toXScale="0.5"
                 *         android:toYScale="0.5" />
                 *
                 * </set>
                 * android:shareInterpolator表示set标签下的多个动画共用一个插值器，如果不需要，那就单独设置插值器。
                 * 2.代码中设置：
                 */
                AnimationSet animationSet = new AnimationSet(true);
                TranslateAnimation translateAnimation1 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
                translateAnimation1.setDuration(2000);
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation1.setDuration(2000);
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(1, 0);
                alphaAnimation1.setDuration(2000);
                RotateAnimation rotateAnimation1 = new RotateAnimation(90, -90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation1.setDuration(2000);
                animationSet.addAnimation(translateAnimation1);
                animationSet.addAnimation(scaleAnimation1);
                animationSet.addAnimation(alphaAnimation1);
                animationSet.addAnimation(rotateAnimation1);
                ivPicture.startAnimation(animationSet);
                break;
        }
    }
}
