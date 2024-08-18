package com.ecommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.User;
import com.ecommerce.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Crear nuevo usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Leer un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Leer todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Actualizar usuario
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setState(userDetails.getState());

        return userRepository.save(user);
    }

    // Eliminar usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}