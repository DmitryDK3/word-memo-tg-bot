package com.github.DmitryDK3.wordmemotgbot.service;

import com.github.DmitryDK3.wordmemotgbot.bot.WordsMemoBot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Component
public class SendMessageToBotImpl implements SendMessageToBot {

    private WordsMemoBot wordsMemoBot;

    public SendMessageToBotImpl(WordsMemoBot wordsMemoBot) {
        this.wordsMemoBot = wordsMemoBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            wordsMemoBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
