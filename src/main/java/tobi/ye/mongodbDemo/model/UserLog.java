/*
 * Copyright (c) 2014 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package tobi.ye.mongodbDemo.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by YangFan on 14/12/22 下午8:33.
 * <p/>
 * 用户日志实体类
 */
@Data
public class UserLog implements Serializable {

    private static final long serialVersionUID = -6404693304781553534L;

    /**
     * 用户IP
     */
    private String userIp;
    /**
     * 操作设备
     */
    private Object device;
    /**
     * 操作时间,默认值为当前时间
     */
    private final Timestamp operationTime = new Timestamp(System.currentTimeMillis());
    /**
     * 操作模块
     */
    private String operationType;
    /**
     * 操作方法
     */
    private String operationMethod;
    /**
     * 操作模块
     */
    private String module;
    /**
     * 日志内容
     */
    private String content;
    /**
     * 耗时毫秒数
     */
    private Long timeCost;
    /**
     * 参数
     */
    private Object para;
    /**
     * 如果请求出错，则记录错误消息
     */
    private String errorMsg;

}
/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/
