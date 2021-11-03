package com.github.DmitryDK3.wordmemotgbot.command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBotImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;


@DisplayName("Unit test for command container")
class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendMessageToBot sendMessageToBot = Mockito.mock(SendMessageToBotImpl.class);
        commandContainer = new CommandContainer(sendMessageToBot);
    }

    @Test
    public void shouldRetrieveAllCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class,command.getClass());

                });
    }

    @Test
    public void shouldReturnUnknownCommand() {

        String command = "/fdfdf";
        Command command1 = commandContainer.retrieveCommand(command);
        Assertions.assertEquals(UnknownCommand.class, command1.getClass());
    }
}