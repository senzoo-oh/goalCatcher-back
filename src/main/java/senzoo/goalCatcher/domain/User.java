package senzoo.goalCatcher.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // indicate that the ID should be generated automatically.
    @Column(name="user_id")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")   // mappedby를 사용하여 연관관계의 주인이 아님을 나타냄
    private List<Goal> goals;

    @OneToMany(mappedBy = "sender")
    private List<FriendRequest> sentRequests;

    @OneToMany(mappedBy = "receiver")
    private List<FriendRequest> receivedRequests;
}
