package com.payserver.membership.application.port.out;

import com.payserver.membership.domain.Membership;

public interface FindMembershipPort {
    Membership findMembership(
            Membership.MembershipId membershipId
    );
}
