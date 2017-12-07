package com.baidu.che.codrivercustom;

import com.baidu.che.codriversdk.InitListener;
import com.baidu.che.codriversdk.manager.CdAsrManager;
import com.baidu.che.codriversdk.manager.CdMediaManager;
import com.baidu.che.codriversdk.manager.CdPhoneManager;
import com.baidu.che.codriversdk.manager.CdSystemManager;
import com.baidu.che.codriversdk.manager.CdTTSPlayerManager;
import android.os.Handler;

public class CoDriverRunnable implements InitListener {

    private static final String TAG = "CoDriverCustomApp";
    private Handler mHandler;

    public CoDriverRunnable() {
        mHandler = new Handler();
    }

    @Override
    public void onConnectedToRemote() {

        CdPhoneManager.getInstance().setPhoneTool(new CdPhoneManager.PhoneTool() {
            @Override
            public void dialNum(String number) {
                LogUtil.d(TAG, "dialNum() param=" + number);
                CdTTSPlayerManager.getInstance().playAndShow("即将为您拨打" + number);
            }

        });

        CdSystemManager.getInstance().setSystemTool(new CdSystemManager.SystemTool() {
            @Override
            public void closeFeature(String feature) {
                LogUtil.d(TAG, "closeFeature");
                FeatureClimate.closeFeature(feature);

            }

            @Override
            public void openFeature(String feature) {
                LogUtil.d(TAG, "openFeature"+feature);
                FeatureClimate.openFeature(feature);
            }

            @Override
            public void increaseFeature(String feature) {
                LogUtil.d(TAG, "increaseFeature");
                FeatureClimate.increaseFeature(feature);
            }

            @Override
            public void reduceFeature(String feature) {
                LogUtil.d(TAG, "reduceFeature");
                FeatureClimate.reduceFeature(feature);
            }

            @Override
            public void maxFeature(String feature) {
                LogUtil.d(TAG, "maxFeature");
                FeatureClimate.maxFeature(feature);
            }

            @Override
            public void minFeature(String feature) {
                LogUtil.d(TAG, "minFeature");
                FeatureClimate.minFeature(feature);
            }

            @Override
            public void operateFeature(String action) {
                LogUtil.d(TAG, "operateFeature action=" + action);
                FeatureClimate.operateFeature(action);

            }
        });


        CdMediaManager.getInstance().setMediaTool(new CdMediaManager.MediaTool() {
            @Override
            public void openRadio() {
                LogUtil.d(TAG, "openRadio");
//                FeatureRadio.cmdRadio(mModeBase);
                CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openFM() {
                LogUtil.d(TAG, "openFM");
//                FeatureRadio.cmdRadio_FM(mModeBase);
                CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openFMChannel(String channel) {
                LogUtil.d(TAG, "openFMChannel:" + channel);
                float freq;
                try {
                    freq = Float.valueOf(channel).floatValue();
//                    FeatureRadio.cmdRadio_setFrequency(mModeBase, AV_MODE.FM, freq);
                    CdAsrManager.getInstance().closeDialog();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    CdTTSPlayerManager.getInstance().playAndShow("打开FM失败，请重试");
                }
            }

            @Override
            public void openAM() {
                LogUtil.d(TAG, "openAM");
//                FeatureRadio.cmdRadio_AM(mModeBase);
                CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openAMChannel(String channel) {
                LogUtil.d(TAG, "openAMChannel:" + channel);
                float freq;
                try {
                    freq = Float.valueOf(channel).floatValue();
//                    FeatureRadio.cmdRadio_setFrequency(mModeBase, AV_MODE.AM, freq);
                    CdAsrManager.getInstance().closeDialog();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    CdTTSPlayerManager.getInstance().playAndShow("打开AM失败，请重试");
                }
            }

            @Override
            public void openPodcast() {
                LogUtil.d(TAG, "openPodcast");
            }

            @Override
            public void openMusicUsb() {
                LogUtil.d(TAG, "openMusicUsb");
//                FeatureUsb.cmdUsbMusic(mModeBase);
                CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openMusicCd() {
                LogUtil.d(TAG, "openMusicCd");
//                    FeatureDisc.cmdMusic(mModeBase);
                    CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openMusicAux() {
                LogUtil.d(TAG, "openMusicAux");
//                    FeatureAux.cmdAUX(mModeBase);
                    CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openMusicIpod() {
                LogUtil.d(TAG, "openMusicIpod");
//                    FeatureiPod.cmdIpod(mModeBase);
                    CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openMusicBt() {
                LogUtil.d(TAG, "openMusicBt");
//                    FeatureBtAudio.cmdBtAudio(mModeBase);
                    CdAsrManager.getInstance().closeDialog();
            }

            @Override
            public void openMyMusic() {
                LogUtil.d(TAG, "openMyMusic");
//                    FeatureMyMusic.cmdMyMusic(mModeBase);
                    CdAsrManager.getInstance().closeDialog();
            }
        });

        CdAsrManager.getInstance().setAsrTool(new CdAsrManager.AsrTool() {

            @Override
            public void onVrDialogShow() {
                LogUtil.d(TAG, "onVrDialogShow");
            }

            @Override
            public void onVrDialogDismiss() {
                LogUtil.d(TAG, "onVrDialogDismiss");
            }
        });
    }

    @Override
    public void onDisconnectedToRemote() {

    }

}
