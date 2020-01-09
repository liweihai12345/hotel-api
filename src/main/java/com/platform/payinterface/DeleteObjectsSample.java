package com.platform.payinterface;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @Description:
 * @Author: liweihai
 * @Date: Created in 2019/6/5 11:55
 */
public class DeleteObjectsSample {

    private static String endpoint = "https://oss-cn-zhangjiakou.aliyuncs.com";
    private static String accessKeyId = "LTAI2ZYpaSckgbLy";
    private static String accessKeySecret = "QrgRv5ybuoQMn97hCnR8TSB3500p1D";

    private static String bucketName = "ddtyfile";

    public static void main(String[] args) throws IOException {
        /*
         * Constructs a client instance with your account for accessing OSS
         */
        OSS client = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


//        String objectName = "community/c14deaec-7827-4fb1-bac9-eeba7a5ba59b.png";
//
//// 创建OSSClient实例。
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//
//// 删除文件。
//        ossClient.deleteObject(bucketName, objectName);
//
//// 关闭OSSClient。
//        ossClient.shutdown();

        try {
            /*
             * Batch put objects into the bucket
             */
            final String content = "Thank you for using Aliyun Object Storage Service";
            final String keyPrefix = "MyObjectKey";
            String objects = "community/01378488-592b-443c-984f-4cbc12c8cd82.png" +
                    ",community/01394c05-3bc8-41ee-b47f-2caddfbf27f2.png" +
                    ",community/0139e96b-97a7-4270-9bad-3cc25c335184_1080x1430.png" +
                    ",community/013a938c-6486-4abb-bf96-aa5d066472cc.png" +
                    ",community/013b2de1-ef57-4204-92f8-9a2fdf1ab1c0.png" +
                    ",community/013cd7e5-ab1f-4058-a2b6-4e33c283c9b3.png" +
                    ",community/01426305-b2ef-430c-9cfe-8daf4e382b72.png" +
                    ",community/01426539-5fda-44b1-8aca-eb2c744b67ee_1080x1923.png" +
                    ",community/014c400c-e516-4c9e-adf8-a26b63729db5.png" +
                    ",community/014d3126-4b61-499e-b2a4-060d5c565ee3.png" +
                    ",community/014d4e83-9c56-4470-ae54-57387896139b.png" +
                    ",community/02038488-3867-475f-9c05-6e552ca4da70_1080x1439.png" +
                    ",community/0205bd60-49bf-412f-b04a-6c8c00b19f6c.png" +
                    ",community/02084b3b-7acb-4be0-a40c-a1245e805c85_1080x1448.png" +
                    ",community/02099953-c48c-4f22-ab5c-87449d449502_348x464.png" +
                    ",community/020d48bd-9745-4087-8ab5-7298f57a1f30_1080x1563.png" +
                    ",community/0212046c-3167-42a9-850c-788eed176526.png" +
                    ",community/0213caf3-0866-426e-8fea-797c8d533451.png" +
                    ",community/021480ff-4dcd-4b56-95e3-46a094baa742.png" +
                    ",community/01f015d8-1358-48da-bb37-07e270a27667.png" +
                    ",community/01f0a3ca-f0fa-41e5-8126-e0c5e4346d8e.png" +
                    ",community/01f0ed1c-9472-4002-b896-216c95dc214b_720x950.png" +
                    ",community/01f143c2-f8ba-4ee3-8fec-de9b0c106fd2.png" +
                    ",community/01f15f7d-6bee-41e1-9bc9-85409087f5bf.png" +
                    ",community/01f1742c-20b6-4f85-9847-2a4d85801165.png" +
                    ",community/01f32f3f-b0ce-4d9d-aef8-a75be07b655a.png" +
                    ",community/01f42d98-1994-4e3f-b025-d94a849a33a8.png" +
                    ",community/01f7c1e4-5b80-400d-8dd7-0df9a1c88601.png" +
                    ",community/01f8cd29-f527-43c6-a438-d3751663ec37.png" +
                    ",community/01fa914a-66cc-471e-af15-2bd10d34a45e_348x464.png" +
                    ",community/01fad182-2290-4b47-ab3c-ee10dff2fb86.png" +
                    ",community/0201c344-c893-4da6-a564-b4ef70ae38d6_1080x1749.png" +
                    ",community/01d7e8e6-0336-4d18-ae98-2cd2f407c46f.png" +
                    ",community/01d7ecfb-9feb-4db6-8d55-4c87cb050b4d.png" +
                    ",community/01d86f24-8589-4e60-b797-6b4b2f4330b5.png" +
                    ",community/01d96558-4bb2-4763-a7c4-ca2910f73ab1.png" +
                    ",community/01d9f15d-3555-4831-bc18-95cbe4634873_1440x2019.png" +
                    ",community/01daaccc-a3b5-4ef9-a5ce-57dfa803006b_315x420.png" +
                    ",community/01dbcbb8-dd5e-4911-8094-467ae90cf414.png" +
                    ",community/01de101b-e7f0-4d44-8a0c-6b6eb8e86e21.png" +
                    ",community/01e82423-a17b-439b-a804-5e6f898906b2.png" +
                    ",community/01be382c-4447-416c-8905-449a5d2f66a8.png" +
                    ",community/01bfb933-afd3-4529-944d-2e432731b6f8.png" +
                    ",community/01c07f89-8fab-481b-a497-ff5ea1013f5c_1080x1922.png" +
                    ",community/01c965cb-d991-4424-bdec-89634240dd51.png" +
                    ",community/01ca2e7c-f4be-40d7-a05a-7e20a02c14ac.png" +
                    ",community/01ca99ef-c34e-4a8f-a823-82c70eb96f81_720x1025.png" +
                    ",community/01d22b53-b451-4cbe-8555-0c6ea02eb255.png" +
                    ",community/01d40f28-dfdb-4972-869b-75e154817ba4.png" +
                    ",community/01d4d7a4-ffeb-4743-90b5-a4a7d5249d27_1080x1439.png" +
                    ",community/01a8cca4-eb88-4660-9404-ebb7f16d82a6_315x420.png" +
                    ",community/01aaa39a-a562-43de-97cd-d48c7fd28fdd.png" +
                    ",community/01b16c8c-14f3-4357-8c30-2638565141c9.png" +
                    ",community/01b1bc11-09fd-49b0-96ed-ed47e743faf0.png" +
                    ",community/01b35a88-e0c6-4221-8aa5-32d96069fbc3_348x464.png" +
                    ",community/01b634d1-8199-4915-aa47-947a0af5466b.png" +
                    ",community/01b841df-1bb4-44b3-af79-142c4834fd46.png" +
                    ",community/01b9660f-b57f-415c-a619-f10bd76cd860.png" +
                    ",community/01ba2a69-db78-4b4b-ad6b-31a2e715182f.png" +
                    ",community/0190b32e-60be-4a49-8cf7-e0d9ce039997.png" +
                    ",community/0191665a-67c0-4ed8-bf01-7b26f5ba1248_1080x1439.png" +
                    ",community/01972534-37fa-433e-ac22-bcceadd2a3fe.png" +
                    ",community/01981657-5340-4cf9-8c90-176c5d465173_348x464.png" +
                    ",community/019f7fdf-f8b0-4086-b2cc-9cd7d7e199b1.png" +
                    ",community/01a0bcc9-d351-4200-be1a-e9c8f322deb1.png" +
                    ",community/01a2a06d-0b31-419d-8d31-66d6e842b806.png" +
                    ",community/017dfb30-469e-401f-becb-e23c647059f1_315x420.png" +
                    ",community/01834f9a-0596-47e1-80b3-ccfd19d12127.png" +
                    ",community/01856873-80bf-4780-9ead-9968aedd8e15_1080x1563.png" +
                    ",community/0186d337-215d-478f-a657-4c0a04f6d028.png" +
                    ",community/0187db31-4c8f-4689-9f6e-500b5f39f6c3.png" +
                    ",community/018c8d90-35a3-4010-9ecc-c943e72a0745_1080x1657.png" +
                    ",community/018cb9ce-756a-4c23-8a7c-aeb85e393ec8.png" +
                    ",community/016a0bfc-3abf-46e9-b4ee-4b6c73562524.png" +
                    ",community/016be936-bca6-4827-bb7e-84b0c496b7e7_1080x1426.png" +
                    ",community/016c40f3-fb9b-49b7-ad93-bc84f4875d6c.png" +
                    ",community/016c51c6-e3dd-4903-962a-8f24c33e6547_348x464.png" +
                    ",community/016e417e-760b-4e3e-bc9b-7db6fe77d5a2_315x420.png" +
                    ",community/01731219-8bdf-4a10-9982-fe347622d877.png" +
                    ",community/0173e603-5a5f-4c2d-a3e7-f92c1b2fa50c.png" +
                    ",community/0177c179-402f-4ff7-8032-e6e4ae21431f.png" +
                    ",community/01785d9d-d5cc-4e38-b990-395ef92c13c0.png" +
                    ",community/0179b793-b92a-4926-ab88-04dd4f434b15.png" +
                    ",community/017afe9f-02d2-4004-ad9e-8afed066e99c.png" +
                    ",community/017b74df-8b8a-440a-9938-9c8b7e43bb8c_348x464.png" +
                    ",community/017d0cbb-e918-466b-a1e7-633d54c7d5b2.png" +
                    ",community/014e9713-3027-4040-b07a-9d6827e527c1_1080x1439.png" +
                    ",community/014eaafd-0702-47ff-87a1-c3cac9a1769a.png" +
                    ",community/0152e9e6-fcde-404e-9fb6-d75a5b265008.png" +
                    ",community/0154b399-ca4d-4c36-98d3-22aed2e28ed9.png" +
                    ",community/0154f316-3833-4c4b-a406-8f54c01ed121.png" +
                    ",community/01559349-89d4-4010-84da-9f3892f21b27.png" +
                    ",community/01575492-8b54-4729-9be5-ade62bb6be54.png" +
                    ",community/0157e449-b041-404c-b05c-442174c33ca1.png" +
                    ",community/015843a0-d566-42b4-b72c-b51901b4da65.png" +
                    ",community/015a1183-c580-4241-8e03-08b6b7e36703.png" +
                    ",community/015addf7-d725-4a32-bc14-12f6526bf1f6.png" +
                    ",community/015b6646-1359-4ca1-a5a1-914db80285f4.png" +
                    ",community/01641ba3-504f-4dfe-aa33-3e4a689eaa0b.png" +
                    ",community/0166b12a-9e1c-4b4e-a527-8f473faddb43_1080x1774.png" +
                    ",community/0167ec5d-b7c9-4d06-a2c8-819682546723_1080x1563.png";
            String[] arr = objects.split(",");
            List<String> keys = Arrays.asList(arr);
//            for (int i = 0; i < 100; i++) {
//                String key = keyPrefix + i;
//                InputStream instream = new ByteArrayInputStream(content.getBytes());
//                client.putObject(bucketName, key, instream);
//                System.out.println("Succeed to put object " + key);
//                keys.add(key);
//            }
            System.out.println();

            /*
             * Delete all objects uploaded recently under the bucket
             */
            System.out.println("\nDeleting all objects:");
            DeleteObjectsResult deleteObjectsResult = client.deleteObjects(
                    new DeleteObjectsRequest(bucketName).withKeys(keys));
            List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
            for (String object : deletedObjects) {
                System.out.println("\t" + object);
            }
            System.out.println();

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            client.shutdown();
        }
    }
}
