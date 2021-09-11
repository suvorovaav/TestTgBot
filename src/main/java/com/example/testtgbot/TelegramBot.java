package com.example.testtgbot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.Webhook;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Slf4j
@Getter
@Setter
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramBot extends SpringWebhookBot {

//    static final String botPath = "https://api.telegram.org/bot1992447323:AAHg0hUUC8OR6ykrqR4bboHF-ok27OVNHxw/setWebhook?url=https://625f-90-154-71-60.ngrok.io";
//    static final String TOKEN = "1992447323:AAHg0hUUC8OR6ykrqR4bboHF-ok27OVNHxw";
//    static final String USERNAME = "SuperMailingBot";

    String botPath;
    String botToken;
    String botUsername;

    public TelegramBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void sendMessage(){

        User user = new User();
        user.setUserName("SuperMailingBot");

        Contact contact = new Contact();
        contact.setPhoneNumber("+79654061923");

        Message message = new Message();
        message.setCaption("Greeting");
        message.setFrom(user);
        message.setContact(contact);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId("1");
        sendMessage.setText("Well, all information looks like noise until you break the code.");
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        System.out.println("update.hasMessage: " + update.hasMessage());
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText("Well, all information looks like noise until you break the code.");
            return sendMessage;
        } else {
            return null;
        }
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

}
