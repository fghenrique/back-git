package br.com.fabricio.apigit.DAO;

import br.com.fabricio.apigit.models.Roles;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RolesDAO extends PagingAndSortingRepository<Roles, Integer> {
    Roles findByNome(String nome);
}
