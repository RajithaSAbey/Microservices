package com.reesby.ratingdataservice.resource;

import com.reesby.ratingdataservice.models.Rating;
import com.reesby.ratingdataservice.models.UserRatings;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsData")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String userId){
        List< Rating> ratings= Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 7)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setUserRating(ratings);
        return userRatings;
    }
}
