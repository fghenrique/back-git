package br.com.fabricio.apigit.dataprovider.git.call;

import br.com.fabricio.apigit.dataprovider.git.dto.ProgramadoresDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallGitHub {

    public ProgramadoresDTO[] Programadores(String path) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProgramadoresDTO[]> response =
                restTemplate.getForEntity(
                        path,
                        ProgramadoresDTO[].class);
        ProgramadoresDTO[] employees = response.getBody();
        return employees;
    }
}
