package com.abhijeet.codepracticedsa.submission.service;

import com.abhijeet.codepracticedsa.data.entity.Users;
import com.abhijeet.codepracticedsa.data.repository.CodeRepository;
import com.abhijeet.codepracticedsa.data.repository.UsersRepository;
import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.web.UserRegisterInput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final CodeRepository codeRepository;
    private final UsersRepository usersRepository;

    public UserService(CodeRepository codeRepository, UsersRepository usersRepository) {
        this.codeRepository = codeRepository;
        this.usersRepository = usersRepository;
    }

    public List<UserEntry> getUserList(){
        Iterable<Users> users = this.usersRepository.findAll();
        List<UserEntry> listOfUsers = new ArrayList<>();
        users.forEach(user -> {
            UserEntry userEntry = new UserEntry();
            userEntry.setUserId(user.getUserId());
            userEntry.setEmail(user.getEmail());
            userEntry.setFirstName(user.getFirstName());
            userEntry.setLastName(user.getLastName());
            userEntry.setLangPref(user.getLangPref());
            userEntry.setPassword(user.getPassword());
            listOfUsers.add(userEntry);
        });
        return listOfUsers;
    }

    public long getUserCount(){
        return this.usersRepository.count();
    }

    public void addUser(UserRegisterInput userRegisterInput){
        Users user = new Users();
        user.setEmail(userRegisterInput.getEmail());
        user.setFirstName(userRegisterInput.getFirstName());
        user.setLastName(userRegisterInput.getLastName());
        user.setPassword(userRegisterInput.getPassword());
        user.setLangPref(userRegisterInput.getLangPref());
        usersRepository.save(user);
    }
}
