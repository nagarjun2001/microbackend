package com.kids.serviceimplementation;

import com.kids.model.Video;
import com.kids.repo.VideoRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VideoSerImplTest {

    @InjectMocks
    private VideoSerImpl videoService;

    @Mock
    private VideoRepo videoRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Video video = new Video();
        doNothing().when(videoRepo).save(video);
        videoService.save(video);
        verify(videoRepo, times(1)).save(video);
    }

    @Test
    void testFindPending() {
        Video video = new Video();
        List<Video> videos = Arrays.asList(video);
        when(videoRepo.findPending()).thenReturn(videos);
        List<Video> result = videoService.findPending();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertSame(video, result.get(0));
        verify(videoRepo, times(1)).findPending();
    }

    @Test
    void testFindByApproved() {
        Video video = new Video();
        List<Video> videos = Arrays.asList(video);
        when(videoRepo.findByApproved()).thenReturn(videos);
        List<Video> result = videoService.findByApproved();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertSame(video, result.get(0));
        verify(videoRepo, times(1)).findByApproved();
    }

    @Test
    void testFindById() {
        Video video = new Video();
        when(videoRepo.findById(1)).thenReturn(video);
        Video result = videoService.findById(1);
        assertNotNull(result);
        assertSame(video, result);
        verify(videoRepo, times(1)).findById(1);
    }

    @Test
    void testUpdateVideo() {
        Video video = new Video();
        doNothing().when(videoRepo).updateVideo(video);
        videoService.updateVideo(video);
        verify(videoRepo, times(1)).updateVideo(video);
    }

    @Test
    void testDeleteVideo() {
        doNothing().when(videoRepo).deleteVideo(1);
        videoService.deleteVideo(1);
        verify(videoRepo, times(1)).deleteVideo(1);
    }

    @Test
    void testGetAllVideos() {
        Video video = new Video();
        List<Video> videos = Arrays.asList(video);
        when(videoRepo.getAllVideos()).thenReturn(videos);
        List<Video> result = videoService.getAllVideos();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertSame(video, result.get(0));
        verify(videoRepo, times(1)).getAllVideos();
    }

    @Test
    void testFindByCreatorId() {
        Video video = new Video();
        List<Video> videos = Arrays.asList(video);
        when(videoRepo.findByCreatorId(1)).thenReturn(videos);
        List<Video> result = videoService.findByCreatorId(1);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertSame(video, result.get(0));
        verify(videoRepo, times(1)).findByCreatorId(1);
    }
}
