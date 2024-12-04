package com.example.demo.repository;

import com.example.demo.AbstractBaseIntegrationTest;
import com.example.demo.repository.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.Rollback;

@DataMongoTest
public class UserRepositoryTest extends AbstractBaseIntegrationTest {
    @Autowired
    private UserRepository repository;

    @Test
    @Rollback(value = false)
    public void findByUserType() {
        UserEntity entity = Instancio.create(UserEntity.class);
        UserEntity persistedObj = repository.save(entity);
        System.out.println(persistedObj);
        Assertions.assertThat(persistedObj.getName()).isNotNull();
    }

}
