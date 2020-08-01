package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.Post;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PostDao {
    //查询所有发表的文章
    List<Post> findAllPosts();
    Post findPostById(int id);
    List<Post> findAllPostsByCategoryId(int id);
    void savePost(Post savePost);
    //查询所有文章
    List<Post> findAllPostsIncludeDraft();
    //改变文章状态
    void changePostIsDraft(@Param("id") Integer id, @Param("is_draft") boolean is_draft,@Param("public_time") Date public_time);
    //修改文章内容
    void changePostContent(Post changePost);
    //删除文章
    void deletePostById(Integer post_id);
    //获取文章统计
    int getTotal();

    int getAllDraft();
}
