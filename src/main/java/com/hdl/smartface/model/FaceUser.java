package com.hdl.smartface.model;

/**
 * 人脸用户信息
 */
public class FaceUser {
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 人脸特征值
     */
    private String featrue;
    /**
     * 人脸图片
     */
    private String pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeatrue() {
        return featrue;
    }

    public void setFeatrue(String featrue) {
        this.featrue = featrue;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "FaceUser{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", featrue='" + featrue + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
