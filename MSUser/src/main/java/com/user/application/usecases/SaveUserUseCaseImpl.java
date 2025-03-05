package com.user.application.usecases;

import com.user.domain.User;
import com.user.infraestructure.ports.in.usecase.SaveUserUseCase;
import com.user.infraestructure.ports.out.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
@AllArgsConstructor
public class SaveUserUseCaseImpl implements SaveUserUseCase {
    private static final String SECRET_KEY = "1234567890123456";

    private final UserPort userPort;

    @Override
    public User execute(User user) throws Exception {
        user.setContrasena(encrypt(user.getContrasena()));

        return userPort.saveUser(user);
    }

    private static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
