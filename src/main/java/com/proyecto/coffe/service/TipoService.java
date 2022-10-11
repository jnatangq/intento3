package com.proyecto.coffe.service;



import java.util.List;

import com.proyecto.coffe.Entity.Tipo;
import com.proyecto.coffe.Repository.ITipoRepository;

public class TipoService implements ITipoService {

    private ITipoRepository tipoRepository;

    public TipoService(ITipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Override
    public List<Tipo> getAllTipos() {
        return tipoRepository.findAllSortByTipo();
    }

    @Override
    public List<Tipo> getTipoByTipo(String tipo) {
        return tipoRepository.findByTipoContaining(tipo);
    }

   

    @Override
    public Tipo saveTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public Tipo getTipoById(Long id) {
        return tipoRepository.getReferenceById(id);

    }

    @Override
    public void deleteTipoById(Long id) {
        tipoRepository.deleteById(id);
    }

    @Override
    public Tipo updateTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public List<Tipo> getTipoByContcafe(String contcafe) {
    
        return null;
    }

}

      