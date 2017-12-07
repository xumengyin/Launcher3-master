package com.baidu.che.codrivercustom;

import com.baidu.che.codriversdk.manager.CdTTSPlayerManager;

public class FeatureClimate {

    private static final String LOG_TAG = "FeatureClimate";

    private static final String INTENT_REGEX = "__";

    private static float minTemp = 0;
    private static float maxTemp = 0;

    public FeatureClimate() {
    }

    public static void closeFeature(String feature) { // ABOUT OFF COMMAND
        LogUtil.d(LOG_TAG, "closeFeature:" + feature);
        String word = "小度暂不支持该功能"; // it is not supported

        if ("climate".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您关闭");
        } else if ("air_conditioner".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您关闭");
        } else if ("internal_recycle".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您关闭");
        } else if ("air_clean".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您关闭");
        } else if ("defrost".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您关闭");
        } else {
            LogUtil.d(LOG_TAG, feature + " is not surpported");
        }
    }

    public static void openFeature(String feature) { // ABOUT ON COMMAND
        LogUtil.d(LOG_TAG, "openFeature:" + feature);

        String word = "小度暂不支持该功能";
        if ("climate".equals(feature)) { // --> Climate on == climate Auto on
            CdTTSPlayerManager.getInstance().playAndShow("以为您开启");
        } else if ("air_conditioner".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您开启");
        } else if ("internal_recycle".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您开启");
        } else if ("air_clean".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您开启");
        } else if ("defrost".equals(feature)) {
            CdTTSPlayerManager.getInstance().playAndShow("以为您开启");
        } else {
            LogUtil.d(LOG_TAG, feature + " is not surpported");
        }
    }

    public static void increaseFeature(String feature) {
        LogUtil.d(LOG_TAG, "increaseFeature:" + feature);

        if ("light".equals(feature)) {

        } else if ("volume".equals(feature)) {

        } else {
            LogUtil.d(LOG_TAG, feature + " is not surpported");
        }

        CdTTSPlayerManager.getInstance().playAndShow("小度暂不支持该功能");
    }

    public static void reduceFeature(String feature) {
        LogUtil.d(LOG_TAG, "reduceFeature:" + feature);

        if ("light".equals(feature)) {

        } else if ("volume".equals(feature)) {

        } else {
            LogUtil.d(LOG_TAG, feature + " is not surpported");
        }
        CdTTSPlayerManager.getInstance().playAndShow("小度暂不支持该功能");
    }

    public static void maxFeature(String feature) {
        LogUtil.d(LOG_TAG, "maxFeature:" + feature);

        if ("light".equals(feature)) {
            LogUtil.d(LOG_TAG, "maxFeature:" + feature);
        } else if ("volume".equals(feature)) {
            LogUtil.d(LOG_TAG, "maxFeature:" + feature);
        } else {
            LogUtil.d(LOG_TAG, feature + " is not surpported");
        }
        CdTTSPlayerManager.getInstance().playAndShow("小度暂不支持该功能");
    }

    public static void minFeature(String feature) {
        LogUtil.d(LOG_TAG, "minFeature:" + feature);

        if ("light".equals(feature)) {
            LogUtil.d(LOG_TAG, "maxFeature:" + feature);
        } else if ("volume".equals(feature)) {
            LogUtil.d(LOG_TAG, "maxFeature:" + feature);
        } else {
            LogUtil.d(LOG_TAG, feature + " is not surpported");
        }
        CdTTSPlayerManager.getInstance().playAndShow("小度暂不支持该功能");
    }

    public static void operateFeature(String action) {
        LogUtil.d(LOG_TAG, "operateFeature:" + action);

        try {
            String[] act = action.split(INTENT_REGEX);
            LogUtil.d(LOG_TAG, "action = " + act[0]);
            if ("wind_flow".equals(act[0])) {
                operateWindFlow(act);
            } else if ("wind_direction".equals(act[0])) {
                CdTTSPlayerManager.getInstance().playAndShow("已为您调整风向");
            } else if ("temp".equals(act[0])) {
                operateTemp(act);
            } else {
                LogUtil.d(LOG_TAG, action + " is not surpported");
            }
        } catch (Exception ex) {
            LogUtil.d(LOG_TAG, action + " is not surpported, exception");
            ex.printStackTrace();
        }
    }

    private static void operateTemp(String[] act) {

        if ("max".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整温度");
        } else if ("min".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整温度");
        } else if ("up".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整温度");
        } else if ("cold".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整温度");
        } else if ("down".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整温度");
        } else if ("hot".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整温度");
        } else {
            // 设置空调异常 -> exceptional case
            if (Integer.parseInt(act[1]) > maxTemp) {
                CdTTSPlayerManager.getInstance().playAndShow("抱歉，空调最高为" + maxTemp + "度，请重试");
            } else if (Integer.parseInt(act[1]) < minTemp) {
                CdTTSPlayerManager.getInstance().playAndShow("抱歉，空调最低为" + minTemp + "度，请重试");
            } else {
                CdTTSPlayerManager.getInstance().playAndShow("现在温度已为" + Integer.parseInt(act[1]) + "度");
            }
        }
    }

    private static void operateWindFlow(String[] act) {
        if ("up".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整风量");
        } else if ("high".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整风量");
        } else if ("down".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整风量");
        } else if ("low".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整风量");
        } else if ("normal".equals(act[1])) {
            CdTTSPlayerManager.getInstance().playAndShow("已为您调整风量");
        } else {

        }

    }

}
