package com.kindsonthegenius.fleetms.security.controllers;

import com.kindsonthegenius.fleetms.exceptions.UserAlreadyExistException;
import com.kindsonthegenius.fleetms.security.models.User;
import com.kindsonthegenius.fleetms.security.services.RoleService;
import com.kindsonthegenius.fleetms.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private MessageSource messageSource;

    @GetMapping("/security/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "security/users";
    }

    @GetMapping("/security/user/{operation}/{id}")
    public String editOrDetailOperation(@PathVariable("operation") String operation,
                                        @PathVariable("id") Integer id,
                                        Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return String.format("security/user%s", operation);
    }

    @PostMapping("/usersAddNew")
    public String addNew(User user, Model model) throws UserAlreadyExistException {
        userService.register(user);
//        RedirectView redirectView=new RedirectView("/login",true);
        model.addAttribute("registrationSuccess",
                "You can check your email to complete your registration");
        return "security/registrationSuccessful";
    }
}
