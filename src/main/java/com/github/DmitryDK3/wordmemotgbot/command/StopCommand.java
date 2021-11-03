package com.github.DmitryDK3.wordmemotgbot.command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendMessageToBot sendMessageToBot;

    public final static String STOP_COMMAND_MESSAGE = "Останавлены напоминания для всех слов";

    public StopCommand(SendMessageToBot sendMessageToBot) {
        this.sendMessageToBot = sendMessageToBot;
    }

    @Override
    public void execute(Update update) {
        sendMessageToBot.sendMessage(update.getMessage().getChatId().toString(), STOP_COMMAND_MESSAGE);
    }
}
