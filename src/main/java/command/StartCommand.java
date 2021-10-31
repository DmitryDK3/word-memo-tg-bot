package command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendMessageToBot sendMessageToBot;

    public final static String START_MESSAGE = "Привет! Я помогаю запоминать английские слова, введи слово которое хотел бы запомнить.";

    public StartCommand(SendMessageToBot sendMessageToBot) {
        this.sendMessageToBot = sendMessageToBot;
    }

    @Override
    public void execute(Update update) {
        sendMessageToBot.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
