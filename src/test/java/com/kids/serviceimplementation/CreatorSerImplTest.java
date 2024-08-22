package com.kids.serviceimplementation;

import com.kids.model.Creator;
import com.kids.repo.CreatorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreatorSerImplTest {

    @InjectMocks
    private CreatorSerImpl creatorService;

    @Mock
    private CreatorRepo creatorRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCreator() {
        Creator creator = new Creator();
        creatorService.saveCreator(creator);
        verify(creatorRepo, times(1)).saveCreator(creator);
    }

    @Test
    public void testFindAllCreator() {
        List<Creator> creators = Collections.singletonList(new Creator());
        when(creatorRepo.findAllCreator()).thenReturn(creators);

        List<Creator> result = creatorService.findAllCreator();
        assertEquals(creators, result);
    }

    @Test
    public void testFindByCreatorId() {
        Creator creator = new Creator();
        when(creatorRepo.findByCreatorId(1)).thenReturn(creator);

        Creator result = creatorService.findByCreatorId(1);
        assertEquals(creator, result);
    }

    @Test
    public void testUpdateCreator() {
        Creator creator = new Creator();
        creatorService.updateCreator(creator);
        verify(creatorRepo, times(1)).updateCreator(creator);
    }

    @Test
    public void testDeleteCreator() {
        creatorService.deleteCreator(1);
        verify(creatorRepo, times(1)).deleteCreator(1);
    }

    @Test
    public void testFindByEmail() {
        Creator creator = new Creator();
        when(creatorRepo.findByEmail("madhan@yahoo.com")).thenReturn(creator);

        Creator result = creatorService.findByEmail("madhan@yahoo.com");
        assertEquals(creator, result);
    }
}
