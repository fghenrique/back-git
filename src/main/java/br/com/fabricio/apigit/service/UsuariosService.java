package br.com.fabricio.apigit.service;

import br.com.fabricio.apigit.models.Usuarios;
import java.util.List;

public interface UsuariosService {
    List<Usuarios> findAll();
    Usuarios findById(Integer id);
    Usuarios findByLogin(String login);
}
