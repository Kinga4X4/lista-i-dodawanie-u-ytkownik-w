package pl.kinga.dodawanieuzytkownikow;

import javassist.compiler.ast.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

}


//    @GetMapping("/users")
//    public @ResponseBody
//    ResponseEntity<String> getUser() {
//        User user = new User();
//        user.setFirstName(user.getFirstName());
//        user.setLastName(user.getLastName());
//        user.setAge(user.getAge());
//        return new ResponseEntity<String>(userService.toString(), HttpStatus.OK);
//    }

//    @RequestMapping("/users")
//    public String getUser(Model model, User user) {
//
//    }

//    @GetMapping("/index")


//    @PostMapping("/add")
//    public String addNumbers(Model model, CalculatorForm form, BindingResult binding) {
//        if(binding.hasErrors()) {
//            return "add"; // powrót do formularza
//        }



