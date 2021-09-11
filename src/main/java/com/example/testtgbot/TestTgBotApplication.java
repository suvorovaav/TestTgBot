package com.example.testtgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.generics.Webhook;
import org.telegram.telegrambots.meta.generics.WebhookBot;

@SpringBootApplication
public class TestTgBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTgBotApplication.class, args);
//        TelegramBot bot = new TelegramBot();
//        Webhook webhook;
//        webhook.setInternalUrl("https://api.telegram.org/bot1992447323:AAHg0hUUC8OR6ykrqR4bboHF-ok27OVNHxw/setWebhook?url=https://625f-90-154-71-60.ngrok.io");
//        bot.setWebhook();
    }
}
