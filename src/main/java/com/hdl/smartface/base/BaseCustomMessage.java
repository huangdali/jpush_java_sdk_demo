package com.hdl.smartface.base;

/**
 * 公共自定义消息返回体
 */
public class BaseCustomMessage<T> {
    /**
     * 消息类型
     */
    private String type;
    /**
     * 消息简介
     */
    private String msg;
    /**
     * 可变参数【扩展参数】
     */
    private T data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseCustomMessage{" +
                "type='" + type + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
