package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="board_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer")
    private User user;

    @OneToMany(mappedBy = "article")
    private List<Comment> comment;

    @CreationTimestamp
    private LocalDateTime rdate;

}
