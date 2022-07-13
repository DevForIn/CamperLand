package com.CamperLand.CT.logic;

import lombok.Data;

import java.util.Date;

@Data
public class Board {
    private int boardRownum;
    private String nickname;
    private String title;
    private String content;
    private int likeCount;
    private int viewCount;
    private Date regDate;

}
