package com.book.reader;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.book.book.AppContext;
import com.tencent.bugly.Bugly;
import com.umeng.analytics.MobclickAgent;


/**
 * 功能描述：实现了对logger的初始化、分包、刷新头的封装、全局activity的监听
 **/
public class BookApplication extends AppContext {

    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        Bugly.init(this, Config.BUGLY_KEY, true);   //更新与崩溃统计初始化

       registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ActivityTack.tack.addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityTack.tack.removeActivity(activity);
            }
        });
    }
}
