package org.project.ghost_forum.annotations;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.project.ghost_forum.dto.UserDto;
import org.project.ghost_forum.dto.UserRegistrationDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Aspect
@RequiredArgsConstructor
@Component
public class EncryptAnnotationAspect {
    private final PasswordEncoder passwordEncoder;

    @Pointcut("@annotation(Encrypt) && args(userDto,..)")
    public void callEncryptableMethod(UserRegistrationDto userDto) {}

    @Before(value = "callEncryptableMethod(userDto)", argNames = "userDto")
    public void beforeCallEncryptableMethod(UserRegistrationDto userDto) {
        System.out.println("Пароль будет зашифрован!");
        System.out.println(userDto);

        String password = userDto.getPassword();

        String encodedPassword = passwordEncoder.encode(password);

        userDto.setPassword(encodedPassword);
    }

    @After(value = "callEncryptableMethod(userDto)", argNames = "userDto")
    public void afterCallEncryptableMethod(UserDto userDto) {
        System.out.println("Сущность юзера сохранена в БД, пароль зашифрован");
        System.out.println(userDto);
    }

}
