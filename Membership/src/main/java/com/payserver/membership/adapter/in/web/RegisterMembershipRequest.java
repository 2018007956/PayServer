package com.payserver.membership.adapter.in.web;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMembershipRequest {
    private String name;
    private String address;
    private String email;
    private boolean isCorp;
}