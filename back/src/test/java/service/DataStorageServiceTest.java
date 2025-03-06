package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.components.DataStorage;
import com.example.coursework.database.repositories.DataStorageRepository;
import com.example.coursework.service.DataStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DataStorageServiceTest {

    @Mock
    private DataStorageRepository dataStorageRepository;

    @InjectMocks
    private DataStorageService dataStorageService;

    @Test
    public void testGetAll_ShouldReturnListOfDataStorage() {
        DataStorage storage1 = new DataStorage(Long.valueOf(1), "Kingston A400", "Kingston", "ssd", "480", 3399);
        DataStorage storage2 = new DataStorage(Long.valueOf(2),"WD Blue", "WD", "hdd", "1000", 5499);
        List<DataStorage> expected = List.of(storage1, storage2);

        when(dataStorageRepository.findAll()).thenReturn(expected);

        List<DataStorage> actual = dataStorageService.getAll();

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(dataStorageRepository, times(1)).findAll();
    }

    @Test
    public void testGetAll_ShouldReturnEmptyList_WhenNoStoragesExist() {
        when(dataStorageRepository.findAll()).thenReturn(Collections.emptyList());

        List<DataStorage> actual = dataStorageService.getAll();

        assertTrue(actual.isEmpty());
        verify(dataStorageRepository, times(1)).findAll();
    }

    @Test
    public void testGetById_ShouldReturnDataStorage_WhenExists() {
        var id = Long.valueOf(1);
        DataStorage expected = new DataStorage(Long.valueOf(1),"Kingston A400", "Kingston", "ssd", "480", 3399);

        when(dataStorageRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<DataStorage> actual = dataStorageService.getById(id);

        assertEquals(expected, actual.get());
        verify(dataStorageRepository, times(1)).findById(id);
    }

    @Test
    public void testGetById_ShouldReturnEmptyValue_WhenNotExists() {
        var id = Long.valueOf(1);
        when(dataStorageRepository.findById(id)).thenReturn(Optional.empty());

        Optional<DataStorage> actual = dataStorageService.getById(id);

        assertFalse(actual.isPresent());
        verify(dataStorageRepository, times(1)).findById(id);
    }
}