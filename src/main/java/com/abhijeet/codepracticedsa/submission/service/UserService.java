package com.abhijeet.codepracticedsa.submission.service;

import com.abhijeet.codepracticedsa.data.entity.AuthGroup;
import com.abhijeet.codepracticedsa.data.entity.User;
import com.abhijeet.codepracticedsa.data.repository.AuthGroupRepository;
import com.abhijeet.codepracticedsa.data.repository.CodeRepository;
import com.abhijeet.codepracticedsa.data.repository.UserRepository;
import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.web.UserRegisterInput;
import com.abhijeet.codepracticedsa.web.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final CodeRepository codeRepository;
    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public UserService(CodeRepository codeRepository, UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.codeRepository = codeRepository;
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    public List<UserEntry> getUserList(){
        Iterable<User> users = this.userRepository.findAll();
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
        return this.userRepository.count();
    }

    public boolean addUser(UserRegisterInput userRegisterInput){
        User user = new User();
        String email = userRegisterInput.getEmail();
        String firstName = userRegisterInput.getFirstName();
        String lastName = userRegisterInput.getLastName();
        String password = userRegisterInput.getPassword();
        String langPref = userRegisterInput.getLangPref();
        if(email.equals("")|| firstName.equals("") || lastName.equals("") || password.equals("") || langPref.equals(""))
            return false;
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setLangPref(langPref);
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("cannot find username" + username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
        return new UserPrincipal(user, authGroups);
    }
}
