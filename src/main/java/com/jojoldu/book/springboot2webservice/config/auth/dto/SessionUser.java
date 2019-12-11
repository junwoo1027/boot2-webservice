package com.jojoldu.book.springboot2webservice.config.auth.dto;

import com.jojoldu.book.springboot2webservice.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 인증된 사용자정보 dto 클래스
 */
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
