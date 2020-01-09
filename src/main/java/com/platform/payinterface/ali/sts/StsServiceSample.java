package com.platform.payinterface.ali.sts;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.platform.payinterface.ali.BaseSample;

public class StsServiceSample extends BaseSample {
    public static void main(String[] args) {
        String endpoint = "sts.aliyuncs.com";
//        String roleArn = "acs:ram::1703944170090280:role/amqpsts";
        String roleArn = "acs:ram::1703944170090280:role/osssts";
        String roleSessionName = "alice";
        String policy = "{\n" +
                "    \"Version\": \"1\", \n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"oss:PutObject\"\n" +
                "            ], \n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:1703944170090280:ddtyfile\" \n" +
                "            ], \n" +
                "            \"Effect\": \"Allow\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"oss:PutObject\"\n" +
                "            ], \n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:1703944170090280:dongdongfile\" \n" +
                "            ], \n" +
                "            \"Effect\": \"Allow\"\n" +
                "        }\n" +
                "    ]\n" +

                "}";
        try {
            // 构造 default profile（参数留空，无需添加 region ID）
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
            // 用 profile 构造 client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setSysEndpoint(endpoint);
            request.setSysMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(policy); // Optional
            request.setDurationSeconds(900l);
            final AssumeRoleResponse response = client.getAcsResponse(request);
            System.out.println("Expiration: " + response.getCredentials().getExpiration());
            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
            System.out.println("RequestId: " + response.getRequestId());
            System.out.println(response.getCredentials());
        } catch (ClientException e) {
            System.out.println("Failed：");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
            System.out.println("RequestId: " + e.getRequestId());
        }
    }

    //授权oss
    public static AssumeRoleResponse authorizeOSSToken() {
        String endpoint = "sts.aliyuncs.com";
        String roleArn = "acs:ram::1703944170090280:role/osssts";
        String roleSessionName = "alice";
        String policy = "{\n" +
                "    \"Version\": \"1\", \n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"oss:PutObject\"\n" +
                "            ], \n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:1703944170090280:ddtyfile\" \n" +
                "            ], \n" +
                "            \"Effect\": \"Allow\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"oss:PutObject\"\n" +
                "            ], \n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:1703944170090280:dongdongfile\" \n" +
                "            ], \n" +
                "            \"Effect\": \"Allow\"\n" +
                "        }\n" +
                "    ]\n" +

                "}";
        return executeAssume(endpoint, roleArn, roleSessionName, policy);
    }

    //授权amqp
    public static AssumeRoleResponse authorizeAmqpToken() {
        String endpoint = "sts.aliyuncs.com";
        String roleArn = "acs:ram::1703944170090280:role/amqpsts";
        String roleSessionName = "alice";
        String policy = "{\n" +
                "    \"Version\": \"1\",\n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"amqp:GetVhost\"\n" +
                "            ],\n" +
                "            \"Resource\": \"acs:amqp:*:*:/vhosts/test-ddtymq\",\n" +
                "            \"Effect\": \"Allow\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"amqp:CreatExchange\",\n" +
                "                \"amqp:GetExchange\",\n" +
                "                \"amqp:CreateQueue\",\n" +
                "                \"amqp:GetQueue\",\n" +
                "                \"amqp:BasicRecover\",\n" +
                "                \"amqp:BasicPublish\",\n" +
                "                \"amqp:BasicAck\",\n" +
                "                \"amqp:BasicNack\"\n" +
                "            ],\n" +
                "            \"Resource\": \"acs:amqp:*:*:/vhosts/test-ddtymq/*\",\n" +
                "            \"Effect\": \"Allow\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        return executeAssume(endpoint, roleArn, roleSessionName, policy);

    }

    public static AssumeRoleResponse executeAssume(String endpoint, String roleArn, String roleSessionName, String policy) {
        try {
            // 构造 default profile（参数留空，无需添加 region ID）
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
            // 用 profile 构造 client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setSysEndpoint(endpoint);
            request.setSysMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(policy); // Optional
            request.setDurationSeconds(900l);
            final AssumeRoleResponse response = client.getAcsResponse(request);
            return response;
        } catch (ClientException e) {

        }
        return null;
    }
}