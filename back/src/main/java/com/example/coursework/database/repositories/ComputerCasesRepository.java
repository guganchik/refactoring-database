package com.example.coursework.database.repositories;

import com.example.coursework.components.ComputerCases;
import com.example.coursework.components.DataStorage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerCasesRepository extends CrudRepository<ComputerCases, Integer> {
    @Query("SELECT * FROM ComputerCases;")
    List<ComputerCases> getAll();

    @Query("SELECT * FROM ComputerCases where id=:id;")
    ComputerCases getById(@Param("id") int id);

    @Query("SELECT * FROM ComputerCases WHERE (:color is NULL or color = :color) AND " +
            "(:formfactor is NULL or formfactor = :formfactor) AND" +
            "(:minprice is NULL or price >= :minprice) AND" +
            "(:maxprice is NULL or price <= :maxprice);")
    List<ComputerCases> setFilter(@Param("color") String color, @Param("formfactor") String formfactor,
                                  @Param("minprice") String minprice, @Param("maxprice") String maxprice);
}
