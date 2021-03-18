package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryMapperTest {
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void categoryToCategoryDto() {
        Category category = new Category();
        category.setName("Fruits001");
        category.setId(1001L);

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDto(category);
        assertEquals("Fruits001", categoryDTO.getName());

    }


    @Test
    void categoryDTOToCategory() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Fruits001");
        categoryDTO.setId(1001L);

        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        assertEquals(1001L, category.getId());
    }
}