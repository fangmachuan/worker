package com.aynu.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117659623";

    // 商户私钥
    public static  String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCLFNoZZM7+DwD40csLJWmYnF7kGoPpH92+7Xz0PFSyGI01KDsmPo6I6U0MpSjRomhQBcMvHeTMKKgbOViS26l3gDDa8ejlgihN6CWjGkRktAiYeSKLheZNTh39C87f63wAuoP2sQxQ59bXmUIaZtquvaE6rkX1d+zXzgDaEBhwn5hGR3TaXT8nk902dj0LvYHWn/pPuYxEHiqoXsF4u2ZEmWWSuMKnS+/1nKcZFiG5OXwzpMgkPmn0cPe93eJnHiWiq94ptv698XH/b53G+kY2eb6/Bh9Y5mF+rXGsPO1ZZ5oC2awo8IGLQEyeSMHbGUBgGFKFojv4TRXYO3kDejM3AgMBAAECggEALfKGlwsRwycLyCfu71C90Pgf9TW5TIQFivUEad+gj3HC/MO8vsa96gdBOCM8F/2SfpVYxTEYDEaGOvA4DdRZ6SvFeB+hNGlKjWpbPMYJwEcl69FhEzz6N6HOEHIdNyahwc/cltwo2HWvKWztRLGkH0RwhmVaoVysNyNMbr4QhOwHhibVcuYHVgDhrollW7SjvlwLiPAORkF+G1tiN1ms5wKFKOVp7hueDXG7JlMHhwZS87dcl9jzejERUJqmP2kWAPV5wv2WNmKuqrAkLQruxlUiQlHmVDSHdxZNkRoAs4tgPIrGIsOR0f49fr+YdD6e2jE/L9QvfgvlIgCRFEV1GQKBgQDOGFrBRndismWKoz0oey+hc16BC8q3Vnze4kax4N5jrv2tWE/iq+dZf9bkHlmsy8jQ/Hln1UHPcagdHZK+nvfUGP5lTvAWo46nQNjJisl9IOJG37sHrwx15UZsgn4w4k+2IlsvlFxIHKWGUZ4udEltw+qSH9HZh+vw/IzqE2vrWwKBgQCswmG3QhUbWU8yYqlBVzhQLtrFsgrRBc0KTnQgikFYUs9UQHr6u8ACLORwDrpyzG3wENgn282ooIDmPbrIegltgDmBmUq6sxHSMG6qLNqINAoVHQYy0mKn+5FFa96dqEqzPv2oKDRNOwEU0oYk03kOuaSN0GP6mTPzZltFBDKKVQKBgClWVzW3BZElSRqinUy2UJpogocNr25QiaFG73kUKmcCHV2cfgFwC2o3Kwn8UG5JPZE1YsCB1L5gBKE6YkmbpwfCr5vwVlWkHqPLbPAXx0wywVAH5gKniK9I+nQfRGJXsjdM8s87SbspC8ZCLqEQr/21MyJ2AWhJS/i9HyKAHMBLAoGAE54XHopAf1SK67vMYIEZAfHwIdbv54BzIiJ6iV9pwC/XH0gbLvG3Agg7AIaLoZGZQlOHWC9bkTR4rqx/01gYTfjrjs3rcHv5IBcj2esx/Zl7M56SH59IWK72dh2jr992bBhREZFPLx3uJ4EofnINIyDtkLUDRWe0QIV1A8dQPekCgYBUz5xvlswCp1/lgFO7x13EZgMUjH0rvF4ib5El0hVFAibDCRneF1GDdxm6wdDy/fLA98U8/y4/580g/UTGzg26ZKQEcHSunQV/NvhfLYu4JRw1m61pT2md/PZYSwxiC3wrRVEwfg5aLFULg+FVCaxdc8z+bbo5PfgWdX0+s8csJw==";

    // 支付宝公钥
    public static  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlNYUWiiqQ0jJTnGLUKhk8oyGtq0FIXg/jZGyhg8O52pS6/sGo+3e57shp5X3pfJaMx7XgCNUCdhTut5wpGkjRR7xI76fYj+ggWiBoXWBeF7hrG1RkDStvhkawEIWIY0gp/n99UbADi8I0C8CLNmq96PZHDMkj4eA0CgWKM/pdE8OdsXFpHhIJqoMBI9A4JP5IY3LC4kyTnar/XLZRMW6SYRfCZGa6rzsAdTmyhD/I/Jh65+or7RUkZxNAQrvyPTr8bmD5zrcjUWa8wt4KKSroEXj4Tz5Htgr0DcmcZB+z32IzJdShIx66X+hmFl2nhmgFwcAeMzt6c3I1kF+xoSxcwIDAQAB";

    // Ajax服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9999/orders/paysuccess";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "E:\\Html\\myproject\\staticPay";


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

