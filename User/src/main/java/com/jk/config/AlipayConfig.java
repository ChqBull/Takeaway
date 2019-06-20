package com.jk.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092800618060";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgmNiMqxBpveqUhAFQ0EVRKCtZeA9TeKcdgSKDGMyorMTk0bWl7I/drL5Eh4h02JOs4jiGz+XwY5BgUJmwSy77JbTsdMVhmpPRxvRcb28m7VTQGExeQcKIohn5NWMGrWDk9y/3/HVhKNCKIZIjLHiWm4CRkajhUVxL/HISZL3lnODzm9kDOm7hztdIJ5dcAZ2pwCEv+oufKSzdgu2VzmX/bNW/JBZe4gPB4uzjAs9EdBjEqn+tzgTPtfph7jLutgNaT4zEDrZvcnquGFhpPcrGhj7LwkdzTyu43gSqdB4qfATHWQY9kxDaGYlcHGZJlsDT/SS5QwJX8QzdIr0CCOInAgMBAAECggEAWBti+tHDAHBcKTy+yAprbRn/pmcy6VWRQaOePpQ1e/jFUNAouy4sw65I+Knu2EQVyMyXvIaEnTzScbTmjIzC6rCGMQ/jVigLHxTq7WeJcK7WUBB0nWWwh2t/mnSKrpgiR5vBqmjMMRDGUHIYjcmRIvePMs3Z/Du5ykpmfubcNALcwL+fVUfl07y+++fRThI6tsh3xRP4QM7zruRkg/7prM+L65+vPOt72HrBCvk7xBE4Pq2fmWjEoX5PTuGKGzWtqbqHtbBtVDvn+/exXy1+76Qxn/dTdRmlEhmWhGv1vs9o26BiiIp1tb2amR/nFgjBdJB/F3omFiOoIHFwrURK2QKBgQDhYgzbUCFTQvY/v5uZYpAZkHvbTOkqQeOnx9bAGhlcyu0+ZcSZqLLRsYsTsAo/a3YgwCnDpo+EMwKKunr2v6l+mRYndbCakVSeN8d/mqfTYIYj8txV4mrN8Rvs0syxOs/rlfapuBg3N0cmzE65kdX3ySTQyPn+V3ueKbh34l6BSwKBgQC2acpmWaekgy5E3YwE4a/wTSnEtGmNXEfJoyHlo7nHvRDVkAPISxvGGnaq0G2S8yatxyhlAAsPXdFBlENGWIgYKiLdaXrJwxgy/+tgkK2h6/Zl/Z+jOoS6p9H7COZUY1fFd+uiU5cLKVEMLwZQGBELtGpiFELLvMcY2NdKb/N1FQKBgDaYLKsXTus/Ri0M+eD+yg8XO5lUmQpeaYnj03Y3HDupACzkM+pQvfgjfJ/pPaI9IqEuSy+UciFAxfXa1BxfMuxyorYuQPhACfJFarLTQKHoOLYOhybasKpwJCaKrYCk0WasrdJQwLTnU/nm9Y7n75+U/rEAbeYZRN18F64ajG/fAoGAZCJewSCmLmD0nUkg++0IL9mr/BctejQWFFJA4VanPUZEX3fXG7RfYrhUPCB+hhSEPxD807TaXW0a2e0RoSQoUVuQGAs3JFq8hgKGq1PAfQqTEBnR8EDHa8+ELVINXnXKUNQrvcg1OiNMImwOAxmzAcHgREbrA/x1LuaaCHq8IqECgYAVuu+fYFmh442YvIT5mNtXz6Fx/VuVady2NGURG8Jwh89pOFnZ4kxCQnijuYHBVh0nBlv4KSpQiigQSj44IUa9eIqodfbbewPesgX3rFQC5gcqFHj6ibkVV6nb0798cs2EzC5iJsEJm0c2uEo4jUayX8Jdpaf2Oo/+rUkOf3l+Mg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuwGr5Nrl6eQ2S6UwEW4atzH9GnCdkMAw25/onnh029dfFFECUoNDQnjbwXEzroDe7DS466JUnRftmIYMwJrByfPo9D+5wxqzQvIaUL8L6ZppZTBJfOl5RZSRsaJmYFFFzLOpLuI0cmhG5x2GURlsfGpZb+cTsUmbzo3ffte48aA33t28qn6JlSJLzUKACyo/W0xjut3rm44pfY8iSlzmXcvszMEEdRQHF1poSZXeAuWFktEfim3FsPdxmBBzJSkMi0sYT1YXk7DHgrgr/8RaaLdnp77cWQR2o+jghYKIApH9vcQiuP+8nyKwGWrViJB0UfHKpAQL+ycOtbs1pkrV5wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = " http://localhost:3006/goBusinessPage";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}