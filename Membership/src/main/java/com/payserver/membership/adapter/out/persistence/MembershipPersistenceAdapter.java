package com.payserver.membership.adapter.out.persistence;

import com.payserver.membership.application.port.out.FindMembershipPort;
import com.payserver.membership.application.port.out.RegisterMembershipPort;
import com.payserver.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;
    private final MembershipMapper membershipMapper;

    @Override
    // DB 연동
    public void createMembership(Membership.MembershipName membershipName
            , Membership.MembershipEmail membershipEmail
            , Membership.MembershipAddress membershipAddress
            , Membership.MembershipIsValid membershipIsValid
            , Membership.MembershipIsCorp membershipIsCorp
    ){
        membershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.getNameValue(),
                        membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(),
                        membershipIsValid.isValidValue(),
                        membershipIsCorp.isCorpValue()
                )
        );
    }

    @Override
    public Membership findMembership(Membership.MembershipId membershipId) {
        return membershipMapper.mapToDomainEntity(
                membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()))
        );
    }
}
