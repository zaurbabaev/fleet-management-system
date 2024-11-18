package com.kindsonthegenius.fleetms.security.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.security.models.Role;
import com.kindsonthegenius.fleetms.security.models.User;
import com.kindsonthegenius.fleetms.security.repositories.RoleRepository;
import com.kindsonthegenius.fleetms.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void assignUserRole(Integer userId, Integer roleId) {
        User user = userService.getById(userId);
        Role role = getById(roleId);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public void unassignUserRole(Integer userId, Integer roleId) {
        User user = userService.getById(userId);
        user.getRoles().removeIf(x -> x.getId().equals(roleId));
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user) {
        return user.getRoles();
    }

    public List<Role> getUserNotRoles(User user) {
        return roleRepository.getUserNotRoles(user.getId());
    }
}
