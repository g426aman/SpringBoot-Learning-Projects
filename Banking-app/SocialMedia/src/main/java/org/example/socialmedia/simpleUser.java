package org.example.socialmedia;

public class simpleUser implements User{
    PostList postList;
    String userName;

    @Override
    public void setUserName(String userName) {
     this.userName = userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public PostList getPostList() {
        return this.postList;
    }

    @Override
    public void setPostList(PostList postList) {
        this.postList=postList;
    }
}
