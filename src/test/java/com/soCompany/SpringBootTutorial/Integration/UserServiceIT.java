package com.soCompany.SpringBootTutorial.Integration;

import com.soCompany.SpringBootTutorial.annotations.IT;
import com.soCompany.dto.UserEditCreateDto;
import com.soCompany.dto.UserReadDto;
import com.soCompany.entity.Employee;
import com.soCompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@Transactional
public class UserServiceIT {

    @Autowired
    private UserService userService;

    private static final Integer id = 1;

    private static final Integer company_id = 1;

    @Test
    void findAll() {
        List<UserReadDto> userReadDtoList = userService.findAll();
        assertThat(userReadDtoList).hasSize(5);
    }

    @Test
    void findById() {
        Optional<UserReadDto> optionalEmployee = userService.findById(id);
        assertTrue(optionalEmployee.isPresent());
        optionalEmployee.ifPresent(user -> assertTrue(user.getFirstName().equals("John")));
    }

    @Test
    @Rollback
    void create() {
        UserEditCreateDto dto = new UserEditCreateDto(
                id,
                3,
                "John",
                "Smith",
                "Cyber",
                BigDecimal.valueOf(167000),
                null
        );

        UserReadDto actualResult = userService.create(dto);

        assertEquals(dto.getFirstName(), actualResult.getFirstName());
        assertEquals(dto.getLastName(), actualResult.getLastName());
        assertEquals(dto.getSalary(), actualResult.getSalary());
        assertEquals(dto.getHireDate(), actualResult.getHireDate());

    }

    @Test
    void delete() {
        assertFalse(userService.delete(-123));
        assertTrue(userService.delete(34));
    }

}
