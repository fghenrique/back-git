package br.com.fabricio.apigit.controller;


import br.com.fabricio.apigit.models.Usuarios;
import br.com.fabricio.apigit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usrService;

    @GetMapping("user/list")
    public List<Usuarios> list() {
        return usrService.findAll();
    }

    @GetMapping("user/{id}")
    public Usuarios user(@PathVariable("id") Integer id) {
        return usrService.findById(id);
    }

    @GetMapping("user/username/{username}")
    public Usuarios username(@PathVariable("username") String username) {
        return usrService.findByUsername(username);
    }

    @PostMapping("user/save")
    public Usuarios username(@RequestBody Usuarios usuarios) {
        return usrService.save(usuarios);
    }
}