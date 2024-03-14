package com.EmprestimoAmigo.EmprestimoAmigo.service;

import com.EmprestimoAmigo.EmprestimoAmigo.dto.FriendDto;
import com.EmprestimoAmigo.EmprestimoAmigo.models.Friend;

import java.util.List;

public interface FriendService {
    List<FriendDto> findAllFriends();
    void saveFriend(Friend friend);

    FriendDto findFriendById(long friendId);

    void updateFriend(FriendDto friend);
}
