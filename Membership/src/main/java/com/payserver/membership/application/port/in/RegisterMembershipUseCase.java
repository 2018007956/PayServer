package com.payserver.membership.application.port.in;

import com.payserver.membership.domain.Membership;

public interface RegisterMembershipUseCase {
    Membership registerMembership(RegisterMembershipCommand command);
}
