package com.payserver.membership.application.service;

import com.payserver.membership.adapter.out.persistence.MembershipMapper;
import com.payserver.membership.application.port.in.RegisterMembershipCommand;
import com.payserver.membership.application.port.in.RegisterMembershipUseCase;
import com.payserver.membership.application.port.out.RegisterMembershipPort;
import com.payserver.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public void registerMembership(RegisterMembershipCommand command) {
        
        // command 받아서 DB 통신
        //biz logic -> (port, adapter) -> DB : external system
        registerMembershipPort.createMembership(
            new Membership.MembershipName(command.getName()),
            new Membership.MembershipEmail(command.getEmail()),
            new Membership.MembershipAddress(command.getAddress()),
            new Membership.MembershipIsValid(command.isValid()),
            new Membership.MembershipIsCorp(command.isCorp())
        );
    }
}