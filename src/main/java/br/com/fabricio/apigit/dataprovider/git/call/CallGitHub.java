package br.com.fabricio.apigit.dataprovider.git.call;

import br.com.fabricio.apigit.dataprovider.git.dto.ProgramadoresDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class CallGitHub {

    public ProgramadoresDTO Programador(String path) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("fghenrique1", "f4br1c10-socin"));
        ResponseEntity<ProgramadoresDTO> response =
                restTemplate.getForEntity(
                        path,
                        ProgramadoresDTO.class);
        ProgramadoresDTO employees = response.getBody();
        return employees;
    }
}