package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.service.MembershipService;

public class AddProMembershipCommand implements ICommand{
    private final MembershipService membershipService;


    public AddProMembershipCommand(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @Override
    public void execute(List<String> tokens) {
        membershipService.addProMembership();
    }
}