package com.platform.payinterface.ali.sign;

import com.alipay.api.internal.util.AlipaySignature;
import com.platform.payinterface.ali.config.AlipayConfig;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Slf4j
public class RSA {


    private static final String ALGORITHM = "RSA";

    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    private static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static String getAlgorithms(boolean rsa2) {
        return rsa2 ? SIGN_SHA256RSA_ALGORITHMS : SIGN_ALGORITHMS;
    }

    public static String sign(String content, String privateKey, boolean rsa2) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                    Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature
                    .getInstance(getAlgorithms(rsa2));

            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String sign(String content, String privateKey) {

        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                    Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance(AlipayConfig.SIGN_TYPE_VALUE);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature
                    .getInstance(AlipayConfig.SIGN_ALGORITHMS);//
            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * RSA验签名检查
     *
     * @param content        待签名数据
     * @param sign           签名值
     * @param ali_public_key 支付宝公钥
     * @param input_charset  编码格式
     * @return 布尔值
     */
    public static boolean verify(String content, String alysign, String ali_public_key, String input_charset, String sign_type, String sign_algorithms) {
        log.debug("新签名生成开始begin");
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(sign_type);
            byte[] encodedKey = Base64.decode(ali_public_key);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance(sign_algorithms);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(input_charset));
            log.debug("根据支付宝返回的参数生成的新签名:" + signature);
            log.debug("支付宝返回参数中的支付宝的签名:" + alysign);

            boolean result_verify = signature.verify(Base64.decode(alysign));
            return result_verify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 获取加密串
     * @param content
     * @param key
     * @param charset
     * @return
     * @throws Exception
     */
    public static synchronized String getRsaSign(String content,String key,String charset) throws Exception {

        String sign =AlipaySignature.rsaSign(content,key,charset);
        return sign;
    }
}

