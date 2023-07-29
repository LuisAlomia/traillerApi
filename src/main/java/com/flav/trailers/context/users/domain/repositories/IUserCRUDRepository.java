package com.flav.trailers.context.users.domain.repositories;

import com.flav.trailers.context.users.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserCRUDRepository {

    public List<User> findAll();
    public boolean findByEmail(String email);
    public Optional<User> findById(Long id);
    public User create(User user);
    public User update(User user);
    public boolean delete(Long id);
    //public boolean favorite()

}
