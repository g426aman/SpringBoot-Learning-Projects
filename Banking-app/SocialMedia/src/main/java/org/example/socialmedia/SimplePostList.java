package org.example.socialmedia;

import java.util.ArrayList;

public class SimplePostList implements PostList {

    ArrayList<Post> postList;

    public SimplePostList() {
        this.postList=new ArrayList<Post>();
    }

    @Override
    public ArrayList<Post> getAllPosts() {
        return this.postList;
    }

    @Override
    public Post getPost(int id) {
        return this.postList.get(id);
    }

    @Override
    public void setPost(Post post) {
        this.postList.add(post);
    }

    @Override
    public int size() {
        return this.postList.size();
    }
}
