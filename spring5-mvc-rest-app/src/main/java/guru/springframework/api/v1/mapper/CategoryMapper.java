package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    private final ModelMapper modelMapper;

    public CategoryMapper(@Autowired  ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryDTO categoryToCategoryDto(Category category) {
        if (category!=null)
        return modelMapper.map(category, CategoryDTO.class);
        else return new CategoryDTO();
    }

    public Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if (categoryDTO!=null)
        return modelMapper.map(categoryDTO, Category.class);
        else return new Category();
    }
}
