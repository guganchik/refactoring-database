package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.components.ComputerCases;
import com.example.coursework.database.repositories.ComputerCasesRepository;
import com.example.coursework.dto.ComputerCasesFilterDto;
import com.example.coursework.service.ComputerCasesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ComputerCasesServiceTest {

    @Mock
    private ComputerCasesRepository computerCasesRepository;

    @InjectMocks
    private ComputerCasesService computerCasesService;

    @Test
    public void testGetAll_ShouldReturnListOfComputerCases() {
        ComputerCases case1 = new ComputerCases(Long.valueOf(1), "ARDOR GAMING Rare M2 ARGB", "ARDOR GAMING", "черный",
                "Micro-ATX", 6499);
        ComputerCases case2 = new ComputerCases(Long.valueOf(2),"Cougar MX330-F", "Cougar", "черный",
                "Micro-ATX", 5499);
        List<ComputerCases> expected = List.of(case1, case2);

        when(computerCasesRepository.findAll()).thenReturn(expected);

        List<ComputerCases> actual = computerCasesService.getAll();

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(computerCasesRepository, times(1)).findAll();
    }

    @Test
    public void testGetAll_ShouldReturnEmptyList_WhenNoCasesExist() {
        when(computerCasesRepository.findAll()).thenReturn(Collections.emptyList());

        List<ComputerCases> actualCases = computerCasesService.getAll();

        assertTrue(actualCases.isEmpty());
        verify(computerCasesRepository, times(1)).findAll();
    }

    @Test
    public void testGetById_ShouldReturnComputerCase_WhenExists() {
        Long id = Long.valueOf(1);
        ComputerCases expected = new ComputerCases(Long.valueOf(1), "ARDOR GAMING Rare M2 ARGB", "ARDOR GAMING", "черный",
                "Micro-ATX", 6499);

        when(computerCasesRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<ComputerCases> actual = computerCasesService.getById(id);

        assertEquals(expected, actual.get());
        verify(computerCasesRepository, times(1)).findById(id);
    }

    @Test
    public void testGetById_ShouldReturnEmptyValue_WhenNotExists() {
        var id = Long.valueOf(1);
        when(computerCasesRepository.findById(id)).thenReturn(Optional.empty());

        Optional<ComputerCases> actual = computerCasesService.getById(id);

        assertFalse(actual.isPresent());
        verify(computerCasesRepository, times(1)).findById(id);
    }
    @Test
    public void testSetFilter_ShouldReturnFilteredComputerCases() {
        ComputerCasesFilterDto filterDto =
                new ComputerCasesFilterDto("черный", "Micro-ATX", "100", "7000");

        ComputerCases case1 = new ComputerCases(Long.valueOf(1),"ARDOR GAMING Rare M2 ARGB", "ARDOR GAMING", "черный",
                "Micro-ATX", 6499);
        ComputerCases case2 = new ComputerCases(Long.valueOf(2), "Cougar MX330-F", "Cougar", "черный",
                "Micro-ATX", 5499);
        List<ComputerCases> expected = List.of(case1, case2);

        when(computerCasesRepository.filterComputerCases("черный", "Micro-ATX", "100", "7000")).thenReturn(expected);

        List<ComputerCases> actual = computerCasesService.setFilter(filterDto);

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(computerCasesRepository, times(1)).filterComputerCases("черный", "Micro-ATX", "100", "7000");
    }

    @Test
    public void testSetFilter_ShouldReturnEmptyList_WhenNoCasesMatch() {
        ComputerCasesFilterDto filterDto = new ComputerCasesFilterDto("черный", "Micro-ATX", "100", "7000");
        when(computerCasesRepository.filterComputerCases("черный", "Micro-ATX", "100", "7000")).thenReturn(Collections.emptyList());

        List<ComputerCases> actual = computerCasesService.setFilter(filterDto);

        assertTrue(actual.isEmpty());
        verify(computerCasesRepository, times(1)).filterComputerCases("черный", "Micro-ATX", "100", "7000");
    }
}
