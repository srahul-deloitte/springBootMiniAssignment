package com.springboot.miniassignment.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.springboot.miniassignment.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MovieRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;
    public List<Movie> findAll() {
        return dynamoDBMapper.scan(Movie.class, new DynamoDBScanExpression());
    }

    public Movie save(Movie movie) {
        dynamoDBMapper.save(movie);
        return movie;
    }
}
