package com.flav.trailers.context.trailers.genders.application;

import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindAllGenderUseCaseTest {

    @Mock
    private IGenderCRUDRepository repoMock;

    @InjectMocks
    private FindAllGenderUseCase useCase;

    @DisplayName("Should return a list of genders")
    @Test
    void run() {
        //Given
        List<Gender> genders = new ArrayList<>();
        genders.add(new Gender(1L, "luis"));
        genders.add(new Gender(2L, "diego"));

        BDDMockito.given(repoMock.findAll()).willReturn(genders);

        //Where
        List<Gender> listGender = useCase.run();

        //Then
        assertFalse(listGender.isEmpty());
        assertEquals(2, listGender.size());
        assertEquals(2, listGender.get(1).getId());
        assertEquals("luis", listGender.get(0).getName());
    }
}