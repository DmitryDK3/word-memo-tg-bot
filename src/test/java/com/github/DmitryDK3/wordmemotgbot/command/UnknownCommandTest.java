package com.github.DmitryDK3.wordmemotgbot.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit test for Unknown command name")

class UnknownCommandTest extends AbstractCommandText {

    @Override
    String getCommandName() {
        return "fjfgmj";
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendMessageToBot);
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_COMMAND_MESSAGE;
    }
}