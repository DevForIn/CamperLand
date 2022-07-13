package com.CamperLand.CT.logic;

import java.util.Date;

public class board {
    private int boardRownum;
    private String nicname;
    private String title;
    private String content;
    private int likeCount;
    private int viewCount;
    private Date regDate;

    public int getBoardRownum() {
        return boardRownum;
    }

    public void setBoardRownum(int boardRownum) {
        this.boardRownum = boardRownum;
    }

    public String getNicname() {
        return nicname;
    }

    public void setNicname(String nicname) {
        this.nicname = nicname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "board{" +
                "boardRownum=" + boardRownum +
                ", nicname='" + nicname + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", likeCount=" + likeCount +
                ", viewCount=" + viewCount +
                ", regDate=" + regDate +
                '}';
    }
}
