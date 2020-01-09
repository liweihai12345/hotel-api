package com.platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InviteDO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String invitePhone;
    private String phone;
    private Long id;

}
