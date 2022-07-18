package com.CamperLand.CT.logic;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@Accessors(chain = true)
public class User {
    private int userRownum;
    @NotEmpty(message="정보 입력 필요.")
    @Email(message="E-mail 형식으로 입력하세요.")
    private String email;
    @NotEmpty(message="정보 입력 필요.")
    private String id;
    @Size(min=8, max=14, message="비밀번호는 8~14자로 입력하세요.")
    private String pw;
    @NotEmpty(message="정보 입력 필요.")
    private String nickname;
    private String phone;
    private Date regDate;
    private String imageUrl;

}
