package com.kcs3.panda.global.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
@Service
public class FirebaseConfig {


    private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);



    @PostConstruct
    public void init(){
        try{
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/resources/serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                logger.info("Firebase application has been initialized");

            }
        }catch (IOException e){
            logger.error(e.getMessage());
        }
    }
}