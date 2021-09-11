package com.example.testtgbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class Controller {

    private final TelegramBot telegramBot;

    @Autowired
    public Controller(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void onUpdateReceived(@RequestBody Update update) {
        telegramBot.onWebhookUpdateReceived(update);
    }

}
