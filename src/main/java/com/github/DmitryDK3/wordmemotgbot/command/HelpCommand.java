package com.github.DmitryDK3.wordmemotgbot.command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.DmitryDK3.wordmemotgbot.command.CommandName.HELP;
import static com.github.DmitryDK3.wordmemotgbot.command.CommandName.START;
import static com.github.DmitryDK3.wordmemotgbot.command.CommandName.STOP;

public class HelpCommand implements Command{

    private final SendMessageToBot sendMessageToBot;

    public final static String HELP_MESSAGE = String.format("<b>Я знаю следующие команды:</b> \n"
                            + "%s - начать запоминать слова \n"
                            + "%s - завершить работу бота \n"
                            + "%s - список доступных команд",
                            START.getCommandName(),STOP.getCommandName(),HELP.getCommandName());

    public HelpCommand(SendMessageToBot sendMessageToBot) {
        this.sendMessageToBot = sendMessageToBot;
    }


    @Override
    public void execute(Update update) {
        sendMessageToBot.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
