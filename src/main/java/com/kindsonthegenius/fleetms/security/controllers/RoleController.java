package com.kindsonthegenius.fleetms.security.controllers;

import com.kindsonthegenius.fleetms.security.models.Role;
import com.kindsonthegenius.fleetms.security.services.RoleService;
import com.kindsonthegenius.fleetms.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final UserService userService;

    @GetMapping("/security/roles")
    public String getAll(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "security/roles";
    }

    @GetMapping("/security/role/{id}")
    @ResponseBody
    public Role getById(@PathVariable("id") Integer id) {
        return roleService.getById(id);
    }

    @PostMapping("/security/roles")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/security/roles";
    }

    @GetMapping("/security/role/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        roleService.delete(id);
        return "redirect:/security/roles";
    }

    @GetMapping("/security/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable("userId") Integer userId,
                             @PathVariable("roleId") Integer roleId) {
        roleService.assignUserRole(userId, roleId);
        return String.format("redirect:/security/user/Edit/%s", userId);
    }

    @GetMapping("/security/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable("userId") Integer userId,
                               @PathVariable("roleId") Integer roleId) {
        roleService.unassignUserRole(userId, roleId);
        return String.format("redirect:/security/user/Edit/%s", userId);
    }


}
