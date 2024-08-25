package com.kids.serviceimplementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kids.model.Category;
import com.kids.repo.CategoryRepo;

public class CategorySerImplTest {

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private CategorySerImpl categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCategory() {
        Category category = new Category(1, "Rhymes");
        categoryService.saveCategory(category);
        verify(categoryRepo, times(1)).saveCategory(category);
    }

    @Test
    public void testFindAllCategory() {
        Category category1 = new Category(1, "Cartoons");
        Category category2 = new Category(2, "Songs");
        List<Category> categories = Arrays.asList(category1, category2);
        when(categoryRepo.findAllCategory()).thenReturn(categories);
        List<Category> result = categoryService.findAllCategory();
        assertEquals(2, result.size());
        assertTrue(result.contains(category1));
        assertTrue(result.contains(category2));
    }

    @Test
    public void testFindByCategoryId() {
        Category category = new Category(1, "Rhymes");
        when(categoryRepo.findByCategoryId(1)).thenReturn(category);
        Category result = categoryService.findByCategoryId(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Rhymes", result.getCategoryname());
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category(1, "Rhymes");
        categoryService.updateCategory(category);
        verify(categoryRepo, times(1)).updateCategory(category);
    }

    @Test
    public void testDeleteCategory() {
        categoryService.deleteCategory(1);
        verify(categoryRepo, times(1)).deleteCategory(1);
    }

    @Test
    public void testFindByCatName() {
        Category category = new Category(1, "Rhymes");
        when(categoryRepo.findByCatName("Rhymes")).thenReturn(category);
        Category result = categoryService.findByCatName("Rhymes");
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Rhymes", result.getCategoryname());
    }
}
