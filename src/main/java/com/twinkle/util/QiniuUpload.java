package com.twinkle.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.twinkle.pojo.QiniuParam;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * UploadPic(String FilePath,String FileName)，这个方法是根据图片的绝对路径来保存的，第一个参数就是图片的绝对路径，第二个参数就是保存在七牛云空间的图片名称。
 * updateFile(MultipartFile file, String filename)，这个方法就是根据Spring MVC式的MultipartFile类型的图片进行上传的，第二个参数就是保存在七牛云空间的图片名称。
 */
@Component
public class QiniuUpload {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY = QiniuParam.accessKey; //这两个登录七牛 账号里面可以找到
    private static String SECRET_KEY = QiniuParam.secretKey;

    //要上传的空间
    private static String bucketname = QiniuParam.bucket; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

    //密钥配置
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    private static Configuration cfg = new Configuration(Zone.huanan());
    //创建上传对象

    private static UploadManager uploadManager = new UploadManager(cfg);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public static String getUpToken() {
        return auth.uploadToken(bucketname);
    }


    public String UploadPic(String FilePath, String FileName) {
        Configuration cfg = new Configuration(Zone.huanan());
        UploadManager uploadManager = new UploadManager(cfg);
        String accessKey = QiniuParam.accessKey;      //AccessKey的值
        String secretKey = QiniuParam.secretKey;      //SecretKey的值
        String bucket = QiniuParam.bucket;                                          //存储空间名
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(FilePath, FileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return QiniuParam.domain + FileName;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    public String updateFile(MultipartFile file, String filename) throws Exception {
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            InputStream inputStream = file.getInputStream();
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[600]; //buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }

            byte[] uploadBytes = swapStream.toByteArray();
            try {
                Response response = uploadManager.put(uploadBytes, filename, getUpToken());
                //解析上传成功的结果
                DefaultPutRet putRet;
                putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return QiniuParam.domain + putRet.key;

            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                }
            }
        } catch (UnsupportedEncodingException ex) {
        }
        return null;
    }
}
