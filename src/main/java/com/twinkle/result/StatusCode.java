package com.twinkle.result;

/**
 * 状态码类,即Result类中的code属性值
 */
public class StatusCode {
    public static final int OK=20000;//成功
    public static final int ERROR =20001;//失败
    public static final int LOGINERROR =20002;//用户名或密码错误
    public static final int SAVESUCCESS =20003;//保存成功
    public static final int SAVEERROR =20004;//保存失败
    public static final int DELETESUCCESS =20005;//删除成功
    public static final int DELETEERROR =20006;//保存失败
}
