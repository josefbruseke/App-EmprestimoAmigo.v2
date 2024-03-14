package com.EmprestimoAmigo.EmprestimoAmigo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FriendDto {
    private Long id;
    private String name;
    private String telephone;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
