package br.com.fabricio.apigit.controller;

import br.com.fabricio.apigit.dataprovider.git.call.CallGitHub;
import br.com.fabricio.apigit.dataprovider.git.dto.ProgramadorDTO;
import br.com.fabricio.apigit.dataprovider.git.dto.ProgramadoresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {

    @Autowired
    private CallGitHub callGitHub;

    @GetMapping("/list")
    public ProgramadoresDTO lista() {
        ProgramadoresDTO pg1 = callGitHub.Programador("https://api.github.com/search/users?q=repos:>50+followers:>100&page=1");

        ProgramadoresDTO progra = new ProgramadoresDTO();
        progra.setItems(pg1.getItems());
        for (int i = 1; i< 17; i++){
            pg1 = callGitHub.Programador("https://api.github.com/search/users?q=repos:>50+followers:>100&page="+(i+1));
            progra.getItems().addAll(pg1.getItems());
        }
        return progra;
    }
}