package com.payserver.membership.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
}
