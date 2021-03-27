package pl.kinga.dodawanieuzytkownikow;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers() {
        return makeItReadable(userService.getUsersList());
    }

    private String makeItReadable(List<User> users) {
        return users.stream()
                .map(user -> user.getFirstName() + ", " + user.getLastName() + "," + user.getAge())
                .collect(Collectors.joining("<br/>"));
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/add")
    public String addUser(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName")
            String lastName, @RequestParam(name = "age") int age) {
        if (firstName.isEmpty()) {
            return "redirect:/err.html";
        } else {
            userService.addUser(new User(firstName, lastName, age));
            return "redirect:success.html";
        }
    }
}



