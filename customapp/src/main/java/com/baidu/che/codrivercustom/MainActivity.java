/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.che.codrivercustom;

import com.baidu.che.codriversdk.LogUtil;
import com.baidu.che.codriversdk.manager.CdAsrManager;
import com.baidu.che.codriversdk.manager.CdBlueToothManager;
import com.baidu.che.codriversdk.manager.CdPhoneManager;
import com.baidu.che.codriversdk.manager.CdTTSPlayerManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import javax.security.auth.login.LoginException;

public class MainActivity extends Activity implements OnClickListener {
    private String text = "";
    private int x = 0;
    private Button mBtn;
    private Button mBtnPlay;
    private Button mBtnSwitch;
    private Button mBtnStop;
    private Button mBtnRegisterCmd;
    private Button mBtnUnRegister;
    private Button mBtnRegisterCmd1;
    private Button mBtnUnRegister1;
    private Button mBtnBT;
    private Button mBtnRadio;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtnPlay = (Button) findViewById(R.id.btn_play);
        mBtnSwitch = (Button) findViewById(R.id.btn_switch);
        mBtnStop = (Button) findViewById(R.id.btn_stop);
        mBtnRegisterCmd = (Button) findViewById(R.id.register_cmd);
        mBtnUnRegister = (Button) findViewById(R.id.unregister_cmd);
        mBtnRegisterCmd1 = (Button) findViewById(R.id.register_cmd1);
        mBtnUnRegister1 = (Button) findViewById(R.id.unregister_cmd1);
        mBtnBT = (Button) findViewById(R.id.btn_bt);
        mBtnRadio = (Button) findViewById(R.id.btn_radio);
        editText = (EditText) findViewById(R.id.editText);
        mBtn.setOnClickListener(this);
        mBtnPlay.setOnClickListener(this);
        mBtnSwitch.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
        mBtnRegisterCmd.setOnClickListener(this);
        mBtnUnRegister.setOnClickListener(this);
        mBtnRegisterCmd1.setOnClickListener(this);
        mBtnUnRegister1.setOnClickListener(this);
        mBtnBT.setOnClickListener(this);
        mBtnRadio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
//                CdPhoneManager.getInstance().setPhoneTool(new CdPhoneManager.PhoneTool() {
//                    @Override
//                    public void dialNum(String number) {
//                        LogUtil.d(TAG, "dialNum() param=" + number);
//                        //FeatureBtPhone.cmdBtCall(mModeBase, number, null);
//                    }
//                });
                break;
            case R.id.btn_play:
                CdTTSPlayerManager.getInstance().playAndShow(editText.getText().toString());
                break;
            case R.id.btn_switch:
                break;
            case R.id.btn_stop:
                break;
            case R.id.register_cmd:
                break;
            case R.id.unregister_cmd:
                break;
            case R.id.register_cmd1:
                break;
            case R.id.unregister_cmd1:
                break;
            case R.id.btn_bt:
//                CdBlueToothManager.getInstance().setBuleToothTool(new CdBlueToothManager.BuleToothTool()
//                {
//                    @Override
//                    public void openBlueToothView()
//                    {
//                        Log.e(TAG, "openBlueToothView: " );
//                        //FeatureBtPhone.changeBtSettingsScreen(mModeBase);
//                    }
//
//                    @Override
//                    public void openContractDownloadView()
//                    {
//
//                    }
//                });
                break;
            case R.id.btn_radio:

                break;
            default:
                break;
        }

    }

    private static final String TAG = "MainActivity";
}
