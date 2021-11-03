package com.github.DmitryDK3.wordmemotgbot.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit test for start command name")

class StartCommandTest extends AbstractCommandText {

    @Override
    String getCommandName() {
        return CommandName.START.getCommandName();
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendMessageToBot);
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }
}