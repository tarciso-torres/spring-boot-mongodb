package com.redfort.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redfort.workshopmongo.domain.Post;
import com.redfort.workshopmongo.exception.ObjectNotFoundException;
import com.redfort.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}

}
