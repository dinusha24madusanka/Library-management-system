package com.Libary.Management.System.Mini.Project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Member")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MemberID")
    private Integer memberId;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;
}