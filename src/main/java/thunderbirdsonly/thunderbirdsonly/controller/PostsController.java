package thunderbirdsonly.thunderbirdsonly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thunderbirdsonly.thunderbirdsonly.DOT.Post;
import thunderbirdsonly.thunderbirdsonly.pojo.Result;
import thunderbirdsonly.thunderbirdsonly.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    private PostService postService;

    // 创建新的 Post
    @PostMapping("/create")
    public Result createPost(@RequestBody Post post) {
        try {
            postService.createPost(post);
            return Result.success("Post created successfully");
        } catch (Exception e) {
            return Result.error("Failed to create post: " + e.getMessage());
        }
    }

    // 获取所有 Posts
    @GetMapping("/all")
    public Result getAllPosts(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size) {
        int offset = (page - 1) * size; // Calculate the offset
        List<Post> posts = postService.getAllPosts(offset, size);
        return Result.success(posts);
    }

    // 获取指定 ID 的 Post
    @GetMapping("/search/{keyword}/{page}/{size}")
    public Result getPostsByKeyword(@PathVariable String keyword,
                                    @PathVariable int page,
                                    @PathVariable int size) {
        List<Post> posts = postService.getPostsByKeyword(keyword, page, size);
        if (posts != null && !posts.isEmpty()) {
            return Result.success(posts);
        } else {
            return Result.error("No posts found with the given keyword");
        }
    }


    // 更新指定 ID 的 Post
    @PutMapping("/update/{id}")
    public Result updatePost(@PathVariable Long id, @RequestBody Post post) {
        try {
            post.setId(id);
            boolean updated = postService.updatePost(post);
            if (updated) {
                return Result.success("Post updated successfully");
            } else {
                return Result.error("Post not found or update failed");
            }
        } catch (Exception e) {
            return Result.error("Failed to update post: " + e.getMessage());
        }
    }

    // 删除指定 ID 的 Post
    @DeleteMapping("/delete/{id}")
    public Result deletePost(@PathVariable Long id) {
        boolean deleted = postService.deletePost(id);
        if (deleted) {
            return Result.success("Post deleted successfully");
        } else {
            return Result.error("Post not found or delete failed");
        }
    }

    @PostMapping("/{id}/like")
    public Result likePost(@PathVariable Long id, @RequestParam Long userId) {
        try {
            postService.likePost(id, userId);
            return Result.success("Post liked successfully");
        } catch (Exception e) {
            return Result.error("Failed to like post: " + e.getMessage());
        }
    }


    @PostMapping("/{id}/unlike")
    public Result unlikePost(@PathVariable Long id, @RequestParam Long userId) {
        try {
            postService.unlikePost(id, userId);
            return Result.success("Post unliked successfully");
        } catch (Exception e) {
            return Result.error("Failed to unlike post: " + e.getMessage());
        }
    }


    @PostMapping("/{id}/favorite")
    public Result favoritePost(@PathVariable Long id, @RequestParam Long userId) {
        try {
            postService.favoritePost(id, userId);
            return Result.success("Post favorited successfully");
        } catch (Exception e) {
            return Result.error("Failed to favorite post: " + e.getMessage());
        }
    }


    @PostMapping("/{id}/unfavorite")
    public Result unfavoritePost(@PathVariable Long id, @RequestParam Long userId) {
        try {
            postService.unfavoritePost(id, userId);
            return Result.success("Post unfavorited successfully");
        } catch (Exception e) {
            return Result.error("Failed to unfavorite post: " + e.getMessage());
        }
    }


    @GetMapping("/{id}/likes/count")
    public Result getLikesCount(@PathVariable Long id) {
        int count = postService.getLikesCount(id);
        return Result.success(count);
    }


    @GetMapping("/{id}/favorites/count")
    public Result getFavoritesCount(@PathVariable Long id) {
        int count = postService.getFavoritesCount(id);
        return Result.success(count);
    }

}
