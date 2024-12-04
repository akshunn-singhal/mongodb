package com.example.demo.repository;

import com.example.demo.model.UserType;
import com.example.demo.repository.entity.UserEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {
    List<UserEntity> findByUserType(UserType userType);

    @Aggregation(
            pipeline = {
                    "{ '$match' : {'userType': ?0}}",
                    "{'$sort':{'name':-1}}"
            }
    )
    List<UserEntity> findAggregatorData(UserType userType);
}
