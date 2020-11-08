package com.whu.librarylendingplatform.domain;

/**
 * @Author: Colin
 * @Date: 2020/11/8 14:33
 */
public class Request {
    private int requestId;//申请新书的申请号
    private int stuId;//申请学生ID
    private String bookName;//申请书籍名称
    private String bookPress;//申请书籍出版社

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }
}
