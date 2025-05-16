package com.chuanglan.demo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.chuanglan.model.request.SmsSendRequest;
import com.chuanglan.model.response.SmsSendResponse;
import com.chuanglan.util.ChuangLanSmsUtil;
/**
 *
 * @author tianyh
 * @Description:普通短信发送
 */
public class SmsSendDemo {
    public static final String charset = "utf-8";
    // 用户平台API账号(非登录账号,示例:N1234567)
    public static String account = "N8263717";
    // 用户平台API密码(非登录密码)
    public static String password = "U27vundKms4853";

    public static void main(String[] args) throws UnsupportedEncodingException {
        //请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
        String smsSingleRequestServerUrl = "https://smssh1.253.com/msg/v1/send/json";
        // 短信内容
        String msg = "【安易发】验证码为876922，有效时间为5分钟，请及时验证。";
        //手机号码
        String phone = "13917302719";
        //状态报告
        String report= "true";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);
    }
}
