package com.example.metablog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert //insert시에 null인 필드를 제외시켜줌
@Entity //user 클래스가 mysql에 테이블이 생성된다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 db의 넘버링 전략을 따라간다.
    private int id;

    @Column(nullable = false,length = 30, unique = true)
    private String username;

    @Column(nullable = false,length = 100) // 123456 => 해쉬 (비밀번호 암호화)
    private String password;

    @Column(nullable = false,length = 50)
    private String email;

//    @ColumnDefault("user")
//    DB는 RoleType이라는게 없다 그래서 String이라고 알려주기위해 @Enumerated(EnumType.STRING) 사용한다.
    @Enumerated(EnumType.STRING)
    private RoleType role; //ENUM을 쓰는게 좋다 // admin,user,manager 권한을 부여

    @CreationTimestamp //시간이 자동입력
    private Timestamp createDate;
}
