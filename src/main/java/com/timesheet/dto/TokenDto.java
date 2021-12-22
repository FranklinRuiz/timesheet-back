package com.timesheet.dto;


import com.timesheet.persistence.entity.Usuario;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private Usuario user;
    private String accessToken;
}
