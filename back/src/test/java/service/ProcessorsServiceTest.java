package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.components.Processors;
import com.example.coursework.database.repositories.ProcessorsRepository;
import com.example.coursework.service.ProcessorsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProcessorsServiceTest {

    @Mock
    private ProcessorsRepository processorsRepository;

    @InjectMocks
    private ProcessorsService processorsService;

    @Test
    public void testGetAll_ShouldReturnListOfProcessors() {
        Processors processor1 = new Processors(Long.valueOf(1),"Core i5-11600K OEM","Intel","6","3.9",
                "LGA1200", 24990);
        Processors processor2 = new Processors(Long.valueOf(2),"Ryzen 5 3600 OEM","AMD","6","3.6",
                "AM4", 9799);
        List<Processors> expected = List.of(processor1, processor2);

        when(processorsRepository.findAll()).thenReturn(expected);

        List<Processors> actual = processorsService.getAll();

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(processorsRepository, times(1)).findAll();
    }

    @Test
    public void testGetAll_ShouldReturnEmptyList_WhenNoProcessorsExist() {
        when(processorsRepository.findAll()).thenReturn(Collections.emptyList());

        List<Processors> actual = processorsService.getAll();

        assertTrue(actual.isEmpty());
        verify(processorsRepository, times(1)).findAll();
    }

    @Test
    public void testGetByManufacturer_ShouldReturnListOfProcessors_WhenExists() {
        String manufacturer = "Intel";
        Processors processor1 = new Processors(Long.valueOf(1),"Core i5-11600K OEM","Intel","6","3.9",
                "LGA1200", 24990);
        Processors processor2 = new Processors(Long.valueOf(2),"Core I7-10700 S1200 2.9G","Intel","8","2.9",
                "LGA1200", 24499);
        List<Processors> expected = List.of(processor1, processor2);

        when(processorsRepository.getByManufacturer(manufacturer)).thenReturn(expected);

        List<Processors> actual = processorsService.getByManufacturer(manufacturer);

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(processorsRepository, times(1)).getByManufacturer(manufacturer);
    }

    @Test
    public void testGetByManufacturer_ShouldReturnEmptyList_WhenNoProcessorsExist() {
        String manufacturer = "Unknown";
        when(processorsRepository.getByManufacturer(manufacturer)).thenReturn(Collections.emptyList());

        List<Processors> actual = processorsService.getByManufacturer(manufacturer);

        assertTrue(actual.isEmpty());
        verify(processorsRepository, times(1)).getByManufacturer(manufacturer);
    }

    @Test
    public void testGetById_ShouldReturnProcessor_WhenExists() {
        var id = Long.valueOf(1);
        Processors expected = new Processors(Long.valueOf(1),"Core i5-11600K OEM","Intel","6","3.9",
                "LGA1200", 24990);

        when(processorsRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<Processors> actual = processorsService.getById(id);

        assertEquals(expected, actual.get());
        verify(processorsRepository, times(1)).findById(id);
    }

    @Test
    public void testGetById_ShouldReturnEmptyValue_WhenNotExists() {
        var id = Long.valueOf(1);
        when(processorsRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Processors> actual = processorsService.getById(id);

        assertFalse(actual.isPresent());
        verify(processorsRepository, times(1)).findById(id);
    }
}