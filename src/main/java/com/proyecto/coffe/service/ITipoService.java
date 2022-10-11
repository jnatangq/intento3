package com.proyecto.coffe.service;


import java.util.List;

import com.proyecto.coffe.Entity.Tipo;

public interface ITipoService {

    List<Tipo> getAllTipos();

    List<Tipo> getTipoByTipo(String tipo);

    List<Tipo> getTipoByContcafe(String contcafe);

    Tipo saveTipo(Tipo tipo);

    Tipo getTipoById(Long id);

    Tipo updateTipo(Tipo tipo);

    void deleteTipoById(Long id);

}
