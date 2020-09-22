package br.com.fabricio.apigit.service.impl;

import br.com.fabricio.apigit.DAO.RolesDAO;
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

    @Autowired
    private RolesDAO rolesDAO;

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
    public Usuarios findByUsername(String username) { return usrDAO.findByUsername(username); }

    @Override
    public Usuarios save(Usuarios usuarios) {
        usuarios.getRoles().forEach(role ->{
            role.setId(rolesDAO.findByNome(role.getNome()).getId());
        });
        return usrDAO.save(usuarios);
    }
}