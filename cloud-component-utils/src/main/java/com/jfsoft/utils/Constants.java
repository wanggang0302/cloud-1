package com.jfsoft.utils;

/**
 * 常量类
 * wanggang
 * 2017-7-10 16:14:47
 */
public class Constants {

    /** 是否使用：是 */
    public static final String IS_USE_TRUE = "1";
    public static final String IS_USE_FALSE = "0";
    /** 是否使用：全部 */
    public static final String IS_USE_ALL = "2";

    /** 是否删除：是 */
    public static final String IS_DELETE_TRUE = "1";
    public static final String IS_DELETE_FALSE = "0";

    /** 文件类型 */
    public static final String FILE_TYPE_ZIP = ".zip";

    /** 上传状态key */
    public static final String UPLOAD_STATUS_KEY = "status";

    /**
     * 上传状态
     * 0 SUCCESS
     * 1 FAILURE
     */
    public enum UploadStatus {

        SUCCESS("0", "成功"),
        FAILURE("1", "失败");

        private String value;
        private String name;

        private UploadStatus(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public static String getName(String value) {
            for (UploadStatus c : UploadStatus.values()) {
                if (c.getValue().equals(value)) {
                    return c.name;
                }
            }
            return null;
        }
    }

    /**
     * 上传类型（LIS、PEIS、通用类消息）
     * 10 LIS
     * 20 PEIS
     * 30 通用类消息
     */
    public enum UploadType {

        LIS("10", "LIS"),
        PEIS("20", "PEIS"),
        USUAL("30", "通用类消息");

        private String value;
        private String name;

        private UploadType(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public static String getName(String value) {
            for (UploadType c : UploadType.values()) {
                if (c.getValue().equals(value)) {
                    return c.name;
                }
            }
            return null;
        }
    }

}
