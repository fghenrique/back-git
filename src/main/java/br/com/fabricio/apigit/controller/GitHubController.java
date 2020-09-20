package br.com.fabricio.apigit.controller;

import br.com.fabricio.apigit.dataprovider.git.call.CallGitHub;
import br.com.fabricio.apigit.dataprovider.git.dto.ProgramadoresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {

    @Autowired
    private CallGitHub callGitHub;

    @GetMapping("/list")
    public ProgramadoresDTO[] lista(){
        return callGitHub.Programadores("https://api.github.com/users?since=100");
    }
}
