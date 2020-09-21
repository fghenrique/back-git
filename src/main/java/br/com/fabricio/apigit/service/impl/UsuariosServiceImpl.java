package br.com.fabricio.apigit.service.impl;

import br.com.fabricio.apigit.DAO.UsuariosDAO;
import br.com.fabricio.apigit.models.Usuarios;
import br.com.fabricio.apigit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosDAO usrDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return (List<Usuarios>) usrDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios findById(Integer id) {
        return usrDAO.findById(id).orElse(null);
    }

    @Override
    public Usuarios findByLogin(String login) { return usrDAO.findByLogin(login); }
}