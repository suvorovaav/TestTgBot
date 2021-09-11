package com.example.testtgbot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BotConfig {
    @Value("https://api.telegram.org/bot1992447323:AAHg0hUUC8OR6ykrqR4bboHF-ok27OVNHxw/setWebhook?url=https://625f-90-154-71-60.ngrok.io")
    String webHookPath;
    @Value("@SuperMailingBot")
    String userName;
    @Value("1992447323:AAHg0hUUC8OR6ykrqR4bboHF-ok27OVNHxw")
    String botToken;

}
