package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(exclude = "article")
/*
 * @ToString에서 exclude 속성을 통한 무한참조(StackOverflow) 에러를 방지
 * toString() 메서드에서 양방향 참조를 모두 처리하면 무한순환 참조가 발생 할 수 있기 때문에
 * 어느 한쪽에서만 참조할 수 있게 exclude를 해줘야됨
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="board_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    private String content;

    @CreationTimestamp
    private LocalDateTime rdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private Article article;

}