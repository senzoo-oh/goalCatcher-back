package senzoo.goalCatcher.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="friend_request_id")
    private Integer id;

    @JoinColumn(name = "sender_id", nullable = false)
    @ManyToOne
    private User sender;

    @JoinColumn(name = "receiver_id", nullable = false)
    @ManyToOne
    private User receiver;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FriendRequestStatus status;
}
