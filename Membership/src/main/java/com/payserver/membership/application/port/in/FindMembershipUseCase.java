package com.payserver.membership.application.port.in;

import com.payserver.membership.domain.Membership;

public interface FindMembershipUseCase {
    Membership findMembership(FindMembershipCommand command);
}
