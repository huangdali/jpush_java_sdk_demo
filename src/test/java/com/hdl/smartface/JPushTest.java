package com.hdl.smartface;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import com.google.gson.Gson;
import com.hdl.smartface.base.BaseCustomMessage;
import com.hdl.smartface.model.FaceUser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;

public class JPushTest {
    protected static final Logger LOG = LoggerFactory.getLogger(SmartfaceApplicationTests.class);
    /**
     * 极光推送应用管理中获取
     */
    private static final String MASTER_SECRET = "6031870790216966f74410d1";
    /**
     * 极光推送应用管理中获取
     */
    private static final String APP_KEY = "307d4e883d70b727687597fb";

    public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll(ALERT);
    }

    @Test
    public void testPushMsg() {
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_all_all_alert();

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    /**
     * 测试推送自定义消息
     */
    @Test
    public void testPushCustomMsg() {
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setMessage(Message.content("This is a custom msg"))
                .build();
        try {
            PushResult result = jpushClient.sendPush(pushPayload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    /**
     * 测试发送新增人脸信息消息
     */
    @Test
    public void testSendAddFaceUserMessage() {
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
        //模拟构建需要下发的人员信息
        FaceUser faceUser = new FaceUser();
        faceUser.setName("大力哥");
        faceUser.setPhone("155959595959");
        faceUser.setFeatrue("http://face.hdl.com/featrue/155959595959.data");
        faceUser.setPic("http://face.hdl.com/pic/155959595959.png");
        //模拟构建自定义消息体
        BaseCustomMessage<FaceUser> faceUserMessage = new BaseCustomMessage<>();
        faceUserMessage.setType("1001001");//方便测试，这里写死，type和msg建议按下一章的建议来制定
        faceUserMessage.setMsg("新人脸更新");
        faceUserMessage.setData(faceUser);
        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setMessage(Message.content(new Gson().toJson(faceUserMessage)))//使用gson将对象转成json
                .build();
        try {
            PushResult result = jpushClient.sendPush(pushPayload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }
}
