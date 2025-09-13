package com.app.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.blog.Payloads.ApiResponce;
import com.app.blog.Payloads.PostDto;
import com.app.blog.Service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired // Corrected: Added @Autowired for dependency injection
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Corrected: Mapped to a unique URL and fixed the path variable name
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(
    		@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
    		@RequestParam(value = "pageSize", defaultValue = "5", required = false ) Integer pageSize) {
        List<PostDto> allPost = this.postService.getAllPosts(pageNumber, pageSize);
        return new ResponseEntity<>(allPost, HttpStatus.OK);
    }
    
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostsById(@PathVariable Integer postId) {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }
    
    @DeleteMapping("/posts/{postId}")
    public ApiResponce deletePost(@PathVariable Integer postId) {
    	this.postService.deletePost(postId);
    	return new ApiResponce("Post is successfully deleted !!", true);
    }
    
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
    	PostDto updatePost = this.postService.updatePost(postDto, postId);
    	return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
    }
}