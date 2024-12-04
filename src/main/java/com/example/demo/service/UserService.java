package com.example.demo.service;

import com.example.demo.model.UserRecord;
import com.example.demo.model.UserType;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    public List<UserRecord> getUsersByType(UserType userType) {
        List<UserEntity> users = repository.findByUserType(userType);
        return users.stream().map(obj ->
                new UserRecord(obj.getUserId().longValue(), obj.getEmailId(),
                        obj.getName(), obj.getUserType())).toList();
    }

    public Optional<Long> addUser(UserRecord user) {
        UserEntity entity = mapper.map(user, UserEntity.class);
        log.info("converted entity: " + entity);
        entity = repository.save(entity);
        return Optional.of(entity.getUserId().longValue());
    }

    public List<UserRecord> findUsersSortedByAggregator(UserType type) {
        List<UserEntity> aggregatorData = repository.findAggregatorData(type);
        return aggregatorData.stream().map(obj ->
                new UserRecord(obj.getUserId().longValue(), obj.getEmailId(),
                        obj.getName(), obj.getUserType())).toList();
    }
}
