package br.com.fabricio.apigit.DAO;

import br.com.fabricio.apigit.models.Usuarios;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuariosDAO extends PagingAndSortingRepository<Usuarios, Integer> {

    Usuarios findByLogin(String login);
}