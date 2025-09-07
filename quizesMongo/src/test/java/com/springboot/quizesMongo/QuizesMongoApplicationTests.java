package com.springboot.quizesMongo;

import com.springboot.quizesMongo.dto.CategoryDto;
import com.springboot.quizesMongo.services.CategoryServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class QuizesMongoApplicationTests {

	@Autowired
	private CategoryServiceFeign categoryServiceFeign;

	@Test
	public void testFeignAll() {
		List<CategoryDto> categoryDtos = categoryServiceFeign.findAll();
		CategoryDto getOne = categoryServiceFeign.findByCategoryId("1ea510bc-97d2-4b4d-a0ff-e78003888589");
		CategoryDto cat = new CategoryDto();
		cat.setTitle("Testing With Feign");
		cat.setActive(true);
		cat.setDescription("Testing Feign ");
		categoryServiceFeign.create(cat);

		System.out.println(getOne.getTitle());
		categoryDtos.forEach(categoryDto -> System.out.println(categoryDto.getTitle()));
	}

}
