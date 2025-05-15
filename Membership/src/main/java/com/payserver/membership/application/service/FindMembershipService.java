package com.payserver.membership.application.service;

import com.payserver.membership.application.port.in.FindMembershipCommand;
import com.payserver.membership.application.port.in.FindMembershipUseCase;
import com.payserver.membership.application.port.out.FindMembershipPort;
import com.payserver.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        return findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
    }
}
