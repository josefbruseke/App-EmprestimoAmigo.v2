package com.EmprestimoAmigo.EmprestimoAmigo.controller;

import com.EmprestimoAmigo.EmprestimoAmigo.dto.FriendDto;
import com.EmprestimoAmigo.EmprestimoAmigo.models.Friend;
import com.EmprestimoAmigo.EmprestimoAmigo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/friends/add")
    public String addFriend(Model model) {
        Friend friend = new Friend();
        model.addAttribute("friend", friend);
        return "friends-add";

    }

    @PostMapping("/friends/add")
    public String saveFriend(@ModelAttribute("friend") Friend friend) {
        friendService.saveFriend(friend);
        return "redirect:/friends";
    }

    @GetMapping("/friends/{friendId}/edit")
    public String editFriendForm(@PathVariable("friendId") long friendId, Model model){
        FriendDto friend = friendService.findFriendById(friendId);
        model.addAttribute("friend", friend);
        return "friends-edit";

    }

    @PostMapping("/friends/{friendId}/edit")
    public String updateFriend(@PathVariable("friendId") long friendId, @ModelAttribute("friend") FriendDto friend){
        friend.setId(friendId);
        friendService.updateFriend(friend);
        return "redirect:/friends";

    }

}
