package com.github.DmitryDK3.wordmemotgbot.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.DmitryDK3.wordmemotgbot.command.CommandName.NO;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit test for No command name")
class NoCommandTest extends AbstractCommandText{

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendMessageToBot);
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_COMMAND_MESSAGE;
    }
}