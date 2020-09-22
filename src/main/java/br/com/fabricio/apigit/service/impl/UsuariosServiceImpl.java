package br.com.fabricio.apigit.service.impl;

import br.com.fabricio.apigit.DAO.RolesDAO;
import br.com.fabricio.apigit.DAO.UsuariosDAO;
import br.com.fabricio.apigit.models.Usuarios;
import br.com.fabricio.apigit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
        Usuarios user = usrDAO.findByUsername(usuarios.getUsername());
        if(Objects.isNull(user)){
            usuarios.getRoles().forEach(role ->{
                role.setId(rolesDAO.findByNome(role.getNome()).getId());
            });
            return usrDAO.save(usuarios);
        }else{
            user.setPassword(usuarios.getPassword());
            user.setUsername(usuarios.getUsername());
            return usrDAO.save(user);
        }
    }

    @Override
    public void deleteById(Integer id) {
        usrDAO.deleteById(id);
    }
}