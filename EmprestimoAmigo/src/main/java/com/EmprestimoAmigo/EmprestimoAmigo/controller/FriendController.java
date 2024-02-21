package com.EmprestimoAmigo.EmprestimoAmigo.controller;

import com.EmprestimoAmigo.EmprestimoAmigo.dto.FriendDto;
import com.EmprestimoAmigo.EmprestimoAmigo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FriendController {
    private FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/friends")
    public String listFriends(Model model){
        List<FriendDto> friends = friendService.findAllFriends();
        model.addAttribute("friends", friends);
        return "friends-list";
    }
}
