package br.cezario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cezario.model.Post;
import br.cezario.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<List<Post>> findByUser(User user);

}
