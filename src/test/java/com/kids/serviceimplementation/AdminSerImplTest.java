package com.kids.serviceimplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kids.model.Admin;
import com.kids.repo.AdminRepo;

public class AdminSerImplTest {

    @Mock
    private AdminRepo adminRepo;

    @InjectMocks
    private AdminSerImpl adminSerImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin(1, "devi", "Devi", "Devi@123");
        String result = adminSerImpl.addAdmin(admin);
        assertEquals("Admin Added Successfully!", result);
        verify(adminRepo, times(1)).addAdmin(admin);
    }

    @Test
    public void testGetAllAdmin() {
        List<Admin> adminList = List.of(new Admin(1, "Nagarjun", "nagarjun", "Nagarjun@123"),
        		new Admin(2, "Suresh", "sureshbabu", "Suresh@123")
        );
        when(adminRepo.getAllAdmins()).thenReturn(adminList);
        List<Admin> result = adminSerImpl.getAllAdmin();
        assertEquals(adminList, result);
    }

    @Test
    public void testGetAdminById() {
        Admin admin = new Admin(1, "Nagarjun", "nagarjun", "Nagarjun@123");
        when(adminRepo.getAdminById(1)).thenReturn(admin);
        Admin result = adminSerImpl.getAdminById(1);
        assertEquals(admin, result);
    }

    @Test
    public void testGetAdminByUsername() {
        Admin admin = new Admin(1, "Nagarjun", "Nagarjun", "Nagarjun@123");
        when(adminRepo.getAdminByUsername("Nagarjun")).thenReturn(admin);
        Admin result = adminSerImpl.getAdminByUsername("Nagarjun");
        assertEquals(admin, result);
    }
}
