package com.kcs3.panda.domain.user.entity;

import jakarta.persistence.*;
import lombok.Data;  // Lombok의 Data 어노테이션을 사용

@Data  // Lombok을 통해 기본 메소드 자동 생성
@Entity  // JPA 엔터티임을 나타냅니다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO-INCREMENT
    private Long userId;  // 회원 ID, LONG 타입

    @Column(nullable = false, length = 255)  // NOT NULL, VARCHAR(255)
    private String userNickname;  // 닉네임

    @Column(nullable = false, columnDefinition = "int default 0")  // NOT NULL, 기본값 0
    private int userPoint;  // 포인트, INT 타입
}
