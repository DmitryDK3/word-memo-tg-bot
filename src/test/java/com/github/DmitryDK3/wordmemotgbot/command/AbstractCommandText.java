package com.github.DmitryDK3.wordmemotgbot.command;

import com.github.DmitryDK3.wordmemotgbot.bot.WordsMemoBot;
import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBotImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandText {

    protected WordsMemoBot wordsMemoBot = Mockito.mock(WordsMemoBot.class);
    protected SendMessageToBot sendMessageToBot = new SendMessageToBotImpl(wordsMemoBot);

    abstract String getCommandName();
    abstract Command getCommand();
    abstract String getCommandMessage();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {

        Long chat_id = 10023L;

        Message message = Mockito.mock(Message.class);
        Update update = new Update();

        Mockito.when(message.getChatId()).thenReturn(chat_id);
        Mockito.when(message.getText()).thenReturn(getCommandMessage());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(getCommandMessage());
        sendMessage.setChatId(chat_id.toString());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(wordsMemoBot).execute(sendMessage);




    }


}
