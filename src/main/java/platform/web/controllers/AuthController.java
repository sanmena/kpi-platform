package platform.web.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.domain.Repositories.UserRepository;
import platform.domain.entities.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/register")
    public String register(@RequestBody User user) {
        String password = user.getPassword();
        //加密密码
        user.setPassword(passwordToHash(password));
        user = userRepository.save(user);

        return user.getId().toString();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User userRecord = userRepository.findFirstByName(user.getName());
        Gson gson = new Gson();
        if (userRecord == null) {
            return gson.toJson(new LoginError("用户不存在！", -1));
        }

        if (!passwordToHash(user.getPassword()).equals(userRecord.getPassword())) {
            return gson.toJson(new LoginError("用户名或密码错误", -1));
        }

        return gson.toJson(user);
    }


    @GetMapping("/users")
    public String users() {
        List<User> users = (List<User>) userRepository.findAll();
        Gson gson = new Gson();
        return gson.toJson(users);
    }

    private String passwordToHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {
        }
        return null;
    }


    String makeToken(User user) throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256(user.getPassword());
        return JWT.create().withIssuer(user.getName()).sign(algorithm);
    }

}


class LoginError {

    private String message;

    private Integer code;

    public LoginError(String message, Integer code) {
        this.code = code;
        this.message = message;
    }
}