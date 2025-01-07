package thunderbirdsonly.thunderbirdsonly.mapper;

import org.apache.ibatis.annotations.*;
import thunderbirdsonly.thunderbirdsonly.DOT.Post;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO thunderbirds.post (user_id, title, content, create_time, update_time) " +
            "VALUES (#{userId}, #{title}, #{content}, NOW(), NOW())")
    void insertPost(Post post);

    @Select("SELECT * FROM thunderbirds.post WHERE id = #{id}")
    Post selectPostById(@Param("id") Long id);

    @Select("SELECT * FROM thunderbirds.post WHERE LOWER(title) LIKE LOWER(CONCAT('%', #{keyword}, '%')) ORDER BY create_time DESC LIMIT #{offset}, #{limit}")
    List<Post> selectPostsByKeyword(@Param("keyword") String keyword,
                                    @Param("offset") int offset,
                                    @Param("limit") int limit);

    @Select("SELECT * FROM thunderbirds.post ORDER BY create_time DESC LIMIT #{offset}, #{limit}")
    List<Post> selectAllPosts(@Param("offset") int offset, @Param("limit") int limit);

    @Update("UPDATE thunderbirds.post SET title = #{title}, content = #{content}, update_time = NOW() WHERE id = #{id}")
    int updatePost(Post post);

    @Delete("DELETE FROM thunderbirds.post WHERE id = #{id}")
    int deletePost(@Param("id") Long id);


    @Insert("INSERT INTO thunderbirds.user_likes (post_id, user_id, create_time) VALUES (#{postId}, #{userId}, NOW())")
    void insertLike(@Param("postId") Long postId, @Param("userId") Long userId);

    @Delete("DELETE FROM thunderbirds.user_likes WHERE post_id = #{postId} AND user_id = #{userId}")
    void deleteLike(@Param("postId") Long postId, @Param("userId") Long userId);

    @Insert("INSERT INTO thunderbirds.user_favorites (post_id, user_id, create_time) VALUES (#{postId}, #{userId}, NOW())")
    void insertFavorite(@Param("postId") Long postId, @Param("userId") Long userId);

    @Delete("DELETE FROM thunderbirds.user_favorites WHERE post_id = #{postId} AND user_id = #{userId}")
    void deleteFavorite(@Param("postId") Long postId, @Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM thunderbirds.user_likes WHERE post_id = #{postId}")
    int countLikes(@Param("postId") Long postId);

    @Select("SELECT COUNT(*) FROM thunderbirds.user_favorites WHERE post_id = #{postId}")
    int countFavorites(@Param("postId") Long postId);
}

