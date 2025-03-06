package service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.coursework.database.Result;
import com.example.coursework.database.repositories.ResultRepository;
import com.example.coursework.service.ResultService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ResultServiceTest {

    @Mock
    private ResultRepository resultRepository;

    @InjectMocks
    private ResultService resultService;

    @Test
    public void testGetResult_ShouldReturnListOfResults_WhenResultsExist() {
        var price = 1000;
        Result result1 = new Result(1,"ARDOR GAMING Rare M2 ARGB",
                1, "Samsung 870 EVO", 1, "MSI PRO Z790-P WIFI",
                1, "DEEPCOOL DQ750", 1, "Core i5-12600KF S1700 3.7G",
                1, "Kingston Value RAM 8GB", 1, "MSI N730K-2GD3/LP",
                70000);
        Result result2 = new Result(2,"Cougar MX330-F",
                2, "Kingston A400", 2, "ASRock B550M Pro4",
                2, "MONTECH CENTURY 850", 2, "Core i7-10700F S1200 2.9G",
                2, "Patriot Viper 4 Blackout 16GB", 2, "ASUS 90YV0ID0-M0NA00",
                400000);
        List<Result> expected = List.of(result1, result2);

        when(resultRepository.allResult(price)).thenReturn(expected);

        List<Result> actual = resultService.getResult(price);

        assertEquals(expected.size(), actual.size());
        assertIterableEquals(expected, actual);
        verify(resultRepository, times(1)).allResult(price);
    }

    @Test
    public void testGetResult_ShouldReturnEmptyList_WhenNoResultsExist() {
        var price = 1000;

        when(resultRepository.allResult(price)).thenReturn(Collections.emptyList());

        List<Result> actualResults = resultService.getResult(price);

        assertTrue(actualResults.isEmpty());
        verify(resultRepository, times(1)).allResult(price);
    }
}