package br.cezario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.cezario.model.Post;
import br.cezario.model.User;
import br.cezario.model.dto.PostDto;
import br.cezario.repository.PostRepository;
import br.cezario.repository.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Post save(PostDto post, @AuthenticationPrincipal UserDetails userDetails) {
		Post newPost = new Post();
		User user = userRepository.findByUsername(userDetails.getUsername()).get();
		
		newPost.setUser(user);
		newPost.setTexto(post.getTexto());
		return postRepository.save(newPost);
	}
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(long id) {
		return postRepository.findById(id).get();
	}
	
	public List<Post> findByUser(User user){
		return postRepository.findByUser(user).get();
	}

}
