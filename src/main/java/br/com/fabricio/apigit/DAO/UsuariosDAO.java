package br.com.fabricio.apigit.DAO;

import br.com.fabricio.apigit.models.Usuarios;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuariosDAO extends PagingAndSortingRepository<Usuarios, Integer> {
    Usuarios findByUsername(String username);
    void deleteById(Integer id);
}
