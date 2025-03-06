package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.components.PowerSupply;
import com.example.coursework.database.repositories.PowerSupplyRepository;
import com.example.coursework.service.PowerSupplyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PowerSupplyServiceTest {

    @Mock
    private PowerSupplyRepository powerSupplyRepository;

    @InjectMocks
    private PowerSupplyService powerSupplyService;

    @Test
    public void testGetAll_ShouldReturnListOfPowerSupplies() {
        PowerSupply supply1 = new PowerSupply(Long.valueOf(1),"DeepCool PX1000G","DeepCool","1000",
                "true",16699);
        PowerSupply supply2 = new PowerSupply(Long.valueOf(2),"MSI MPG A850G PCIE5","MSI","850",
                "true",16499);
        List<PowerSupply> expected = List.of(supply1, supply2);

        when(powerSupplyRepository.findAll()).thenReturn(expected);

        List<PowerSupply> actual = powerSupplyService.getAll();

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(powerSupplyRepository, times(1)).findAll();
    }

    @Test
    public void testGetAll_ShouldReturnEmptyList_WhenNoSuppliesExist() {
        when(powerSupplyRepository.findAll()).thenReturn(Collections.emptyList());

        List<PowerSupply> actual = powerSupplyService.getAll();

        assertTrue(actual.isEmpty());
        verify(powerSupplyRepository, times(1)).findAll();
    }

    @Test
    public void testGetById_ShouldReturnPowerSupply_WhenExists() {
        var id = Long.valueOf(1);
        PowerSupply expected = new PowerSupply(Long.valueOf(1),"DeepCool PX1000G","DeepCool","1000",
                "true",16699);

        when(powerSupplyRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<PowerSupply> actual = powerSupplyService.getById(id);

        assertEquals(expected, actual.get());
        verify(powerSupplyRepository, times(1)).findById(id);
    }

    @Test
    public void testGetById_ShouldReturnEmptyValue_WhenNotExists() {
        var id = Long.valueOf(1);

        when(powerSupplyRepository.findById(id)).thenReturn(Optional.empty());

        Optional<PowerSupply> actual = powerSupplyService.getById(id);

        assertFalse(actual.isPresent());
        verify(powerSupplyRepository, times(1)).findById(id);
    }
}