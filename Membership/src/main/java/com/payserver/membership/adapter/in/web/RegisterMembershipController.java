package com.payserver.membership.adapter.in.web;

import com.payserver.membership.application.port.in.RegisterMembershipCommand;
import com.payserver.membership.application.port.in.RegisterMembershipUseCase;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;
    @PostMapping(path = "/membership/register")
    void registerMembership(@RequestBody RegisterMembershipRequest request) {

        // request -> Command (추상화 계층)
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        // Usecase
        registerMembershipUseCase.registerMembership(command);
    }
}