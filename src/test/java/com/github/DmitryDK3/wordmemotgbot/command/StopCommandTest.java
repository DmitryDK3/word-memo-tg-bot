package com.github.DmitryDK3.wordmemotgbot.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit test for stop command name")

class StopCommandTest extends AbstractCommandText{

    @Override
    String getCommandName() {
        return CommandName.STOP.getCommandName();
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendMessageToBot);
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_COMMAND_MESSAGE;
    }
}