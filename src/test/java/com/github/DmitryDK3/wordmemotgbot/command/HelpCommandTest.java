package com.github.DmitryDK3.wordmemotgbot.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.DmitryDK3.wordmemotgbot.command.CommandName.HELP;
import static com.github.DmitryDK3.wordmemotgbot.command.HelpCommand.HELP_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit test for help command name")
class HelpCommandTest extends AbstractCommandText {


    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendMessageToBot);
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }
}