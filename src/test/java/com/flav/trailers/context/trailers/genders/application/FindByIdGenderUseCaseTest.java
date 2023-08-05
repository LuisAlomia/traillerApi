package com.flav.trailers.context.trailers.genders.application;

import com.flav.trailers.context.trailers.genders.domain.constants.GenderConstants;
import com.flav.trailers.context.trailers.genders.domain.exeptions.GenderResourceNotFound;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindByIdGenderUseCaseTest {

    @Mock
    private IGenderCRUDRepository repoMock;

    @InjectMocks
    private FindByIdGenderUseCase useCase;

    @DisplayName("Should return gender by Id")
    @Test
    void run() {
        //Given
        Gender gender = Gender.builder().id(1L).name("luis").build();
        BDDMockito.given(repoMock.findById(gender.getId())).willReturn(Optional.of(gender));

        //Where
        Gender findGender = useCase.run(1L);

        //Then
        assertNotNull(findGender);
        assertEquals(1, findGender.getId());
        assertEquals("luis",findGender.getName());
    }

    @DisplayName("Should return new throw GenderResourceNotFound")
    @Test
    void runNotFount() {
        //Given
        Gender gender = Gender.builder().id(1L).name("luis").build();
        BDDMockito.given(repoMock.findById(gender.getId())).willReturn(Optional.empty());

        //Where
        GenderResourceNotFound genderNotFound = assertThrowsExactly(GenderResourceNotFound.class, () -> {
            useCase.run(gender.getId());
        });

        //Then
        assertEquals(String.format(GenderConstants.GENDER_NOT_FOUND, 1L), genderNotFound.getMessage());
    }
}