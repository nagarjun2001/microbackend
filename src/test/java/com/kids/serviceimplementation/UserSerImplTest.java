package com.kids.serviceimplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kids.model.Users;
import com.kids.repo.UserRepo;

public class UserSerImplTest {

    @Mock
    private UserRepo repo;

    @InjectMocks
    private UserSerImpl userSerImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        Users user = new Users();
        doNothing().when(repo).addUser(user);
        userSerImpl.addUser(user);
    }

    @Test
    void testGetAllUsers() {
        Users user1 = new Users();
        Users user2 = new Users();
        List<Users> users = Arrays.asList(user1, user2);
        when(repo.getAllUsers()).thenReturn(users);
        List<Users> result = userSerImpl.getAllUsers();
        assertEquals(users, result);
    }

    @Test
    void testDeleteUsers() {
        doNothing().when(repo).deleteUser(anyInt());
        userSerImpl.deleteUsers(1);
    }

    @Test
    void testFindUserById() {
        Users user = new Users();
        when(repo.findUserById(anyInt())).thenReturn(user);
        Users result = userSerImpl.findUserById(1);
        assertEquals(user, result);
    }

    @Test
    void testUpdateUsers() {
        Users user = new Users();
        doNothing().when(repo).updateUser(user);
        userSerImpl.updateUsers(user);
    }

    @Test
    void testFindByUsername() {
        Users user = new Users();
        when(repo.findByUsername(any())).thenReturn(user);
        Users result = userSerImpl.findByUsername("username");
        assertEquals(user, result);
    }

    @Test
    void testFindByEmail() {
        Users user = new Users();
        when(repo.findByEmail(any())).thenReturn(user);
        Users result = userSerImpl.findByEmail("madhan@gmail.com");
        assertEquals(user, result);
    }

    @Test
    void testAddBlockedVideo() {
        doNothing().when(repo).addBlockedVideo(anyInt(), anyLong());
        userSerImpl.addBlockedVideo(1, 100L);
    }

    @Test
    void testRemoveBlockedVideo() {
        doNothing().when(repo).removeBlockedVideo(anyInt(), anyLong());
        userSerImpl.removeBlockedVideo(1, 100L);
    }

    @Test
    void testAddBlockedCat() {
        doNothing().when(repo).addBlockedCat(anyInt(), any());
        userSerImpl.addBlockedCat(1, 200L);
    }

    @Test
    void testRemoveBlockedCat() {
        doNothing().when(repo).removeBlockedCat(anyInt(), any());
        userSerImpl.removeBlockedCat(1, 200L);
    }
}
