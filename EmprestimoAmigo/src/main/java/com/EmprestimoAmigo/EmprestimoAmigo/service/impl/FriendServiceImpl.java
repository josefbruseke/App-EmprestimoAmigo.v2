package com.EmprestimoAmigo.EmprestimoAmigo.service.impl;

import com.EmprestimoAmigo.EmprestimoAmigo.dto.FriendDto;
import com.EmprestimoAmigo.EmprestimoAmigo.models.Friend;
import com.EmprestimoAmigo.EmprestimoAmigo.repository.FriendRepository;
import com.EmprestimoAmigo.EmprestimoAmigo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendServiceImpl implements FriendService {
    private FriendRepository friendRepository;

    @Autowired
    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public List<FriendDto> findAllFriends() {
        List<Friend> friends = friendRepository.findAll();
        return friends.stream().map(this::mapToFriendDto).collect(Collectors.toList());
    }

    @Override
    public void saveFriend(Friend friend) {
        friendRepository.save(friend);
    }

    @Override
    public FriendDto findFriendById(long friendId) {
        Friend friend = friendRepository.findById(friendId).get();
        return mapToFriendDto(friend);
    }

    @Override
    public void updateFriend(FriendDto friendDto) {
        Friend friend = mapToFriend(friendDto);
        friendRepository.save(friend);
    }

    private Friend mapToFriend(FriendDto friendDto) {
            Friend friend = Friend.builder()
                    .id(friendDto.getId())
                    .name(friendDto.getName())
                    .telephone(friendDto.getTelephone())
                    .build();
            return friend;
    }

    private FriendDto mapToFriendDto(Friend friend){
        FriendDto friendDto = FriendDto.builder()
                .id(friend.getId())
                .name(friend.getName())
                .telephone(friend.getTelephone())
                .updatedOn(friend.getUpdatedOn())
                .createdOn(friend.getCreatedOn())
                .build();
        return friendDto;
    }
}
