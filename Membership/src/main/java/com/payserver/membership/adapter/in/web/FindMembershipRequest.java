package com.payserver.membership.adapter.in.web;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMembershipRequest {
    private String membershipId;
}