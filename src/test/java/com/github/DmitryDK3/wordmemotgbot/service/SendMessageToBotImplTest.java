package com.github.DmitryDK3.wordmemotgbot.service;

import com.github.DmitryDK3.wordmemotgbot.bot.WordsMemoBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit test for send message service")
class SendMessageToBotImplTest {
    private SendMessageToBot sendMessageToBot;
    private WordsMemoBot wordsMemoBot;

    @BeforeEach
    public void init() {
        wordsMemoBot = Mockito.mock(WordsMemoBot.class);
        sendMessageToBot = new SendMessageToBotImpl(wordsMemoBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chat_id = "123";
        String message = "Hi from test";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        sendMessageToBot.sendMessage(chat_id,message);

        Mockito.verify(wordsMemoBot).execute(sendMessage);
    }

}