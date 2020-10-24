package br.cezario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.cezario.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);
	
}
