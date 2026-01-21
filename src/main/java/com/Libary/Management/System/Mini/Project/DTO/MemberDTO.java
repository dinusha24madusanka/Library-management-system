package com.Libary.Management.System.Mini.Project.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Integer memberId;
    private String name;
    private String email;
}