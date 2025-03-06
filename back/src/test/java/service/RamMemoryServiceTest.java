package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.components.RamMemory;
import com.example.coursework.database.repositories.RamMemoryRepository;
import com.example.coursework.service.RamMemoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RamMemoryServiceTest {

    @Mock
    private RamMemoryRepository ramMemoryRepository;

    @InjectMocks
    private RamMemoryService ramMemoryService;

    @Test
    public void testGetAll_ShouldReturnListOfRamMemory() {
        RamMemory ram1 = new RamMemory(Long.valueOf(1), "Patriot Viper 3 DDR3 1600Mhz 16GB", "16", "1600",
                "DDR3", 3999);
        RamMemory ram2 = new RamMemory(Long.valueOf(2),"Kingston Value RAM 8GB", "8", "2666",
                "DDR4", 2499);
        List<RamMemory> expected = List.of(ram1, ram2);

        when(ramMemoryRepository.findAll()).thenReturn(expected);

        List<RamMemory> actual= ramMemoryService.getAll();

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(ramMemoryRepository, times(1)).findAll();
    }

    @Test
    public void testGetAll_ShouldReturnEmptyList_WhenNoRamMemoryExist() {
        when(ramMemoryRepository.findAll()).thenReturn(Collections.emptyList());

        List<RamMemory> actual = ramMemoryService.getAll();

        assertTrue(actual.isEmpty());
        verify(ramMemoryRepository, times(1)).findAll();
    }

    @Test
    public void testGetById_ShouldReturnRamMemory_WhenExists() {
        var id = Long.valueOf(1);
        RamMemory expected = new RamMemory(Long.valueOf(1),"Patriot Viper 3 DDR3 1600Mhz 16GB", "16", "1600",
                "DDR3", 3999);

        when(ramMemoryRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<RamMemory> actual = ramMemoryService.getById(id);

        assertEquals(expected, actual.get());
        verify(ramMemoryRepository, times(1)).findById(id);
    }

    @Test
    public void testGetById_ShouldReturnEmptyValue_WhenNotExists() {
        var id = Long.valueOf(1);

        when(ramMemoryRepository.findById(id)).thenReturn(Optional.empty());

        Optional<RamMemory> actual = ramMemoryService.getById(id);

        assertFalse(actual.isPresent());
        verify(ramMemoryRepository, times(1)).findById(id);
    }
}