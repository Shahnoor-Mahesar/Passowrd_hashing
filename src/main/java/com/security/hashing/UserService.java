package com.security.hashing;
//UserService.java(Abstraction for the repository to save bottleneck for doing multiple operations in controller)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;




    public User saveUser(String uname,String pass)
    {
        User user = new User();
        user.setUsername(uname);
        user.setPassword(Password.hashPassword(pass));
        return userRepository.save(user);
    }

    public User findByUsername(String uname) {
        return userRepository.findByUsername(uname);
    }

    public boolean login(String uname, String pass) {
        User user = userRepository.findByUsername(uname);
        if(Password.verifyPassword(pass,user.getPassword()))
        {
            return true;
        }
        return false;

    }
}
