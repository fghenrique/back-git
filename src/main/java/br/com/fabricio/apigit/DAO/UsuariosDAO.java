package br.com.fabricio.apigit.DAO;

import br.com.fabricio.apigit.models.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosDAO extends CrudRepository<Usuarios, Integer> {
}
