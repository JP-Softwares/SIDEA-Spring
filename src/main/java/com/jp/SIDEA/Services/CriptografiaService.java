package com.jp.SIDEA.Services;

import lombok.Getter;
import lombok.Setter;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Optional;


@Service
@Getter
@Setter
public class CriptografiaService {

    private SecretKey key = null;

    private BasicTextEncryptor basicTextEncryptor = null;

    public void gerarChaveSecreta() throws Exception {
        Optional<BasicTextEncryptor> testeChave = Optional.ofNullable(basicTextEncryptor);
        if(testeChave.isPresent()){
        }else{
            basicTextEncryptor = new BasicTextEncryptor();
            basicTextEncryptor.setPassword("jacintoPinto");
        }
    }

    public String criptografar(String texto) throws Exception {
        gerarChaveSecreta();
        return basicTextEncryptor.encrypt(texto);
    }

    public String descriptografar(String textoCriptografado) throws Exception {
        gerarChaveSecreta();
        return basicTextEncryptor.decrypt(textoCriptografado);
    }
}
