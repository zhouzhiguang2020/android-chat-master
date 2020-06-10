package cn.wildfire.chat.app;

import android.content.Context;
import android.os.Handler;

import androidx.multidex.MultiDexApplication;

import com.apkfuns.logutils.LogUtils;

public class BaseApp extends MultiDexApplication {

    //以下属性应用于整个应用程序，合理利用资源，减少资源浪费
    private static Context mContext;//上下文
    private static long mMainThreadId;//主线程id
    private static Handler mHandler;//主线程Handler

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.getLogConfig()
                .configAllowLog(true)
                .configTagPrefix("野火im日志输出：")
                .configShowBorders(true)
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}");
        //对全局属性赋值
        mContext = getApplicationContext();
        mMainThreadId = android.os.Process.myTid();
        mHandler = new Handler();
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext) {
        BaseApp.mContext = mContext;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }
}
