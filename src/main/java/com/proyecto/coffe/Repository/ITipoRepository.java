package com.proyecto.coffe.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.coffe.Entity.Tipo;

public interface ITipoRepository extends JpaRepository<Tipo, Long> {

    @Query("FROM Tipos t WHERE t.tipo LIKE :productType ")
    public List<Tipo> findByTipoContaining(@Param("tipo") String tipo);

    @Query("FROM Tipos p ORDER BY tipo ASK")
    public List<Tipo> findAllSortByTipo();
}