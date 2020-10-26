package br.cezario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cezario.model.Post;
import br.cezario.model.User;
import br.cezario.model.dto.PostDto;
import br.cezario.service.PostService;

@RestController
@RequestMapping("/api/post")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/")
    public Post create(@RequestBody PostDto post, @AuthenticationPrincipal UserDetails userDetails){
       
		return postService.save(post, userDetails);
    }
	
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Post> listPost(@AuthenticationPrincipal UserDetails userDetails){		
		return postService.findByUser((User) userDetails);
	}

}
