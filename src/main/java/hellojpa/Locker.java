package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Locker {

    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker") // Member.locker
    private Member member;
}
