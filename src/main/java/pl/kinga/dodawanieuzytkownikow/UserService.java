package pl.kinga.dodawanieuzytkownikow;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserService {
    private List<User> usersList;

    public UserService() {
        this.usersList = new ArrayList<>();
        usersList.add(new User("Kinga", "Oleksy", 25));
        usersList.add(new User("Olek", "Kapusta", 40));
        usersList.add(new User("Aga", "Kolec", 15));
    }

    public boolean addUser(User user) {
        return usersList.add(user);
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "usersList=" + usersList +
                '}';
    }
}

