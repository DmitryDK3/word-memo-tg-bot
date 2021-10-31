package com.github.DmitryDK3.wordmemotgbot.bot;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBotImpl;
import command.CommandContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Locale;

import static command.CommandName.NO;

@Component
public class WordsMemoBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    public static String COMMAND_PREFIX = "/";

    private CommandContainer commandContainer;

    public WordsMemoBot() {
        this.commandContainer = new CommandContainer(new SendMessageToBotImpl(this));
    }

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
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase(Locale.ROOT);
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }


        }

    }
}
