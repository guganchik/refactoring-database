package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.components.MotherBoards;
import com.example.coursework.database.repositories.MotherBoardsRepository;
import com.example.coursework.service.MotherBoardsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MotherBoardsServiceTest {

    @Mock
    private MotherBoardsRepository motherBoardsRepository;

    @InjectMocks
    private MotherBoardsService motherBoardsService;

    @Test
    public void testGetAll_ShouldReturnListOfMotherBoards() {
        MotherBoards board1 = new MotherBoards(Long.valueOf(1),"MSI A520M-A PRO", "MSI", "Micro-ATX",
                "DDR4", "PCIe 4.0", "AM4", 7199);
        MotherBoards board2 = new MotherBoards(Long.valueOf(2),"MSI PRO H510M-B", "MSI", "Micro-ATX",
                "DDR4", "PCIe 4.0", "LGA 1200", 6999);
        List<MotherBoards> expected = List.of(board1, board2);

        when(motherBoardsRepository.findAll()).thenReturn(expected);

        List<MotherBoards> actual = motherBoardsService.getAll();

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(motherBoardsRepository, times(1)).findAll();
    }

    @Test
    public void testGetAll_ShouldReturnEmptyList_WhenNoBoardsExist() {
        when(motherBoardsRepository.findAll()).thenReturn(Collections.emptyList());

        List<MotherBoards> actual = motherBoardsService.getAll();

        assertTrue(actual.isEmpty());
        verify(motherBoardsRepository, times(1)).findAll();
    }

    @Test
    public void testGetById_ShouldReturnMotherBoard_WhenExists() {
        var id = Long.valueOf(1);
        MotherBoards expected = new MotherBoards(Long.valueOf(1),"MSI A520M-A PRO", "MSI", "Micro-ATX",
                "DDR4", "PCIe 4.0", "AM4", 7199);

        when(motherBoardsRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<MotherBoards> actual = motherBoardsService.getById(id);

        assertEquals(expected, actual.get());
        verify(motherBoardsRepository, times(1)).findById(id);
    }

    @Test
    public void testGetById_ShouldReturnEmptyValue_WhenNotExists() {
        var id = Long.valueOf(1);

        when(motherBoardsRepository.findById(id)).thenReturn(Optional.empty());

        Optional<MotherBoards> actual = motherBoardsService.getById(id);

        assertFalse(actual.isPresent());
        verify(motherBoardsRepository, times(1)).findById(id);
    }
}