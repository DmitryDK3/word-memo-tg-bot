package com.github.DmitryDK3.wordmemotgbot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class WordsMemoBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        System.out.println(username);
        return username;
    }

    @Override
    public String getBotToken() {
        System.out.println(token);
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatID = update.getMessage().getChatId().toString();
            String message = update.getMessage().getText().trim();

            SendMessage sm = new SendMessage();
            sm.setText(message);
            sm.setChatId(chatID);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }

    }
}
