package com.ecommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.User;
import com.ecommerce.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    // Crear nuevo usuario
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Leer un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Leer un usuario por Email/Username
    public Optional<User> getUserByUserName(String username) {
        return userRepository.findByUsername(username);
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