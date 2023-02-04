package org.example;

import retrofit2.http.GET;
import retrofit2.Call;

import java.util.List;

// We can define all the end-points that we need over here in the interface
// send a get request to posts--> we will get a list of posts
// send a get request to comments--> we will get a list of posts


public interface JSONPlaceholderAPI {
    // creating interface function like below using retrofit
    @GET("posts") // sending a get request to posts
    Call <List<Post>> getPosts();

    @GET("photos")
    Call<List<Photos>> getPhotos();
}
