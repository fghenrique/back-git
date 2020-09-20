package br.com.fabricio.apigit.controller;


import br.com.fabricio.apigit.models.Usuarios;
import br.com.fabricio.apigit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usrService;

    @GetMapping("user/list")
    public List<Usuarios> list(){
        return usrService.findAll();
    }
}
