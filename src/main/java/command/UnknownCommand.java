package command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command{

    private final SendMessageToBot sendMessageToBot;

    public final static String UNKNOWN_COMMAND_MESSAGE = "Не знаю такой команды =( \n Выберите из списка команд /help";

    public UnknownCommand(SendMessageToBot sendMessageToBot) {
        this.sendMessageToBot = sendMessageToBot;
    }

    @Override
    public void execute(Update update) {
        sendMessageToBot.sendMessage(update.getMessage().getChatId().toString(),UNKNOWN_COMMAND_MESSAGE);
    }
}