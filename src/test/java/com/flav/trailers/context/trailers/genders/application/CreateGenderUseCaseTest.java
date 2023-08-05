package com.flav.trailers.context.trailers.genders.application;

import com.flav.trailers.context.trailers.genders.domain.constants.GenderConstants;
import com.flav.trailers.context.trailers.genders.domain.exeptions.GenderResourceExist;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateGenderUseCaseTest {

    @Mock
    private IGenderCRUDRepository repoMock;

    @InjectMocks
    private CreateGenderUseCase useCase;


    @DisplayName("Should create new gender")
    @Test
    void run() {
        //Given
        Gender gender = Gender.builder().id(1L).name("luis").build();

        BDDMockito.given(repoMock.create(gender)).willReturn(gender);

        //Where
        Gender newGender = useCase.run(gender);

        //Then
        assertNotNull(newGender);
        assertEquals("luis", newGender.getName());
    }

    @DisplayName("Should return new throw GenderResourceExist")
    @Test
    void runNotCreate() {
        //Given
        Gender gender = Gender.builder().id(1L).name("luis").build();
        BDDMockito.given(repoMock.findByName(gender.getName())).willReturn(true);

        //Where
        GenderResourceExist genderResourceExist = assertThrowsExactly(GenderResourceExist.class, () -> {
            useCase.run(gender);
        });

        //Then
        assertEquals(String.format(GenderConstants.GENDER_EXITS, gender.getName()),
                genderResourceExist.getMessage());
    }
}