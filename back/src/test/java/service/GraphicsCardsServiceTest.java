package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.components.GraphicsCards;
import com.example.coursework.database.repositories.GraphicsCardsRepository;
import com.example.coursework.service.GraphicsCardsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class GraphicsCardsServiceTest {

    @Mock
    private GraphicsCardsRepository graphicsCardsRepository;

    @InjectMocks
    private GraphicsCardsService graphicsCardsService;

    @Test
    public void testGetAll_ShouldReturnListOfGraphicsCards() {
        GraphicsCards graphicsCard1 = new GraphicsCards(Long.valueOf(1), "MSI N730K-2GD3/LP", "MSI", "2",
                "PCIe 4.0", "300", 5999);
        GraphicsCards graphicsCard2 = new GraphicsCards(Long.valueOf(2), "ASUS PH-RTX3060-12G-V2", "ASUS", "12",
                "PCIe 4.0", "650", 44599);

        List<GraphicsCards> expected = List.of(graphicsCard1, graphicsCard2);

        when(graphicsCardsRepository.findAll()).thenReturn(expected);

        List<GraphicsCards> actual = graphicsCardsService.getAll();

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(graphicsCardsRepository, times(1)).findAll();
    }

    @Test
    public void testGetAll_ShouldReturnEmptyList_WhenNoCardsExist() {
        when(graphicsCardsRepository.findAll()).thenReturn(Collections.emptyList());

        List<GraphicsCards> actual = graphicsCardsService.getAll();

        assertTrue(actual.isEmpty());
        verify(graphicsCardsRepository, times(1)).findAll();
    }

    @Test
    public void testGetById_ShouldReturnGraphicsCard_WhenExists() {
        var id = Long.valueOf(1);
        GraphicsCards expected = new GraphicsCards(Long.valueOf(1),"MSI N730K-2GD3/LP", "MSI", "2",
                "PCIe 4.0", "300", 5999);

        when(graphicsCardsRepository.findById(id)).thenReturn(Optional.of(expected));

       Optional<GraphicsCards> actual = graphicsCardsService.getById(id);

        assertEquals(expected, actual.get());
        verify(graphicsCardsRepository, times(1)).findById(id);
    }

    @Test
    public void testGetById_ShouldReturnEmptyValue_WhenNotExists() {
        var id = Long.valueOf(1);
        when(graphicsCardsRepository.findById(id)).thenReturn(Optional.empty());

        Optional<GraphicsCards> actual = graphicsCardsService.getById(id);

        assertFalse(actual.isPresent());
        verify(graphicsCardsRepository, times(1)).findById(id);
    }
}