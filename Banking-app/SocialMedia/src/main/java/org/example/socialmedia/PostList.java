package org.example.socialmedia;

import java.util.ArrayList;

public interface PostList {
    public ArrayList<Post> getAllPosts();
    public Post getPost(int id);
    public void setPost(Post post);
    public int size();

}
