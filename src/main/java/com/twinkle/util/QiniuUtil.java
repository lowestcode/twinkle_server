package com.twinkle.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

@Component
public class QiniuUtil {

    Configuration cfg = new Configuration(Zone.zone0());
    String accessKey = "zWlCEI5Py_RXeBe7591YdpeGOdmA_oshmbgHyFzx";
    String secretKey = "TkoqYmTtG8S1RQetz-RvgOivmS0xznS5G6dMxX6J";
    String bucket = "twinkle";
    Auth auth = Auth.create(accessKey, secretKey);
    BucketManager bucketManager = new BucketManager(auth, cfg);

    public void getImgList(){
        try {
            //单次批量请求的文件数量不得超过1000
            String[] keyList = new String[]{
                    "abc"
            };
            BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
            batchOperations.addStatOps(bucket, keyList);
            Response response = bucketManager.batch(batchOperations);
            BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);
            for (int i = 0; i < keyList.length; i++) {
                BatchStatus status = batchStatusList[i];
                String key = keyList[i];
                System.out.print("名字"+key+"\t");
                if (status.code == 200) {
                    //文件存在
                    System.out.println(status.data.hash);
                    System.out.println(status.data.mimeType);
                    System.out.println(status.data.fsize);
                    System.out.println(status.data.putTime);
                } else {
                    System.out.println(2);
                    System.out.println(status.data.error);
                }
            }
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
        }
    }

    public void deleteImg(String imageName){
        try {
            bucketManager.delete(bucket, imageName);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
