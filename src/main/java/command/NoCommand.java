package command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendMessageToBot sendMessageToBot;

    public final static String NO_COMMAND_MESSAGE = "Я понимаю только команды начинающиеся с /\n " +
                                                    "Попробуй /help, чтобы посмотреть доступные команды";

    public NoCommand(SendMessageToBot sendMessageToBot) {
        this.sendMessageToBot = sendMessageToBot;
    }

    @Override
    public void execute(Update update) {
        sendMessageToBot.sendMessage(update.getMessage().getChatId().toString(), NO_COMMAND_MESSAGE);
    }
}
