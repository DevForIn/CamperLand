package com.CamperLand.CT.logic;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Data
@Builder
@Accessors(chain = true)
public class User implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
