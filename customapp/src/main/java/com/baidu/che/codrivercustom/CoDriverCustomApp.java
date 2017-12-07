/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.che.codrivercustom;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.manager.CdConfigManager;

import android.app.Application;

/**
 * Created by Chenweiliang01 re 2017/3/15.
 */

public class CoDriverCustomApp extends Application {

    private static final String TAG = "CoDriverCustomApp";
    private static CoDriverCustomApp mInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        LogUtil.d(TAG, "onCreate()");
        CdConfigManager.getInstance().initialize(getApplicationContext(), new CoDriverRunnable());
    }

    public static CoDriverCustomApp getInstance() {
        return mInstance;
    }
}
