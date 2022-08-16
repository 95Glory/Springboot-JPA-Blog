package com.example.metablog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //user 클래스가 mysql에 테이블이 생성된다.
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content;

    private int count;

    // board가 나올때 무조건 나와야 한다면 EAGER 무조건 안나와도 된다면 LAZY 사용
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;//DB는 오브젝트를 저장할 수 없다. FK, 자바는 오트젝트를 저장할 수 있다.

    @CreationTimestamp
    private Timestamp createDate;
}
