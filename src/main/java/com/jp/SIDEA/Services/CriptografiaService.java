package com.jp.SIDEA.Services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Optional;
import org.jasypt.util.text.BasicTextEncryptor;


@Service
@Getter
@Setter
public class CriptografiaService {

    private SecretKey key = null;

    private BasicTextEncryptor basicTextEncryptor = null;

    public void gerarChaveSecreta() throws Exception {
        Optional<SecretKey> testeChave = Optional.ofNullable(key);
        if(testeChave.isPresent()){
        }else{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            setKey(keyGenerator.generateKey());
        }

        basicTextEncryptor = new BasicTextEncryptor();
    }


    public String cripto(String texto) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        return Base64.getEncoder().encodeToString(cipher.doFinal(texto.getBytes()));
    }
    public String criptografar(String texto) throws Exception {
        basicTextEncryptor.setPassword("jacintoPinto");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textoCriptografado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    public String descriptografar(String textoCriptografado) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] textoDescriptografado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));
        return new String(textoDescriptografado);
    }
}
