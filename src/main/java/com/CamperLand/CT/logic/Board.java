package com.CamperLand.CT.logic;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@Accessors(chain = true)
public class Board {
    private int boardRownum;
    private String nickname;
    private String title;
    private String content;
    private int likeCount;
    private int viewCount;
    private Date regDate;
}
