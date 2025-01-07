package thunderbirdsonly.thunderbirdsonly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thunderbirdsonly.thunderbirdsonly.DOT.Post;
import thunderbirdsonly.thunderbirdsonly.mapper.PostMapper;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    // Create a new post
    public void createPost(Post post) {
        postMapper.insertPost(post);
    }

    public List<Post> getPostsByKeyword(String keyword, int page, int size) {
        int offset = (page - 1) * size;
        return postMapper.selectPostsByKeyword(keyword, offset, size);
    }


    public List<Post> getAllPosts(int offset, int limit) {
        return postMapper.selectAllPosts(offset, limit);
    }

    public boolean updatePost(Post post) {
        int rowsAffected = postMapper.updatePost(post);
        return rowsAffected > 0;
    }

    public boolean deletePost(Long id) {
        int rowsAffected = postMapper.deletePost(id);
        return rowsAffected > 0;
    }

    public void likePost(Long postId, Long userId) {
        postMapper.insertLike(postId, userId);
    }

    public void unlikePost(Long postId, Long userId) {
        postMapper.deleteLike(postId, userId);
    }

    public void favoritePost(Long postId, Long userId) {
        postMapper.insertFavorite(postId, userId);
    }

    public void unfavoritePost(Long postId, Long userId) {
        postMapper.deleteFavorite(postId, userId);
    }

    public int getLikesCount(Long postId) {
        return postMapper.countLikes(postId);
    }

    public int getFavoritesCount(Long postId) {
        return postMapper.countFavorites(postId);
    }
}
