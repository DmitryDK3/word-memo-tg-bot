package com.github.DmitryDK3.wordmemotgbot.command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

@Component
public class CommandContainer {

    private final ImmutableMap<String,Command> commands;

    private Command unknownCommand;

    public CommandContainer(SendMessageToBot sendMessageToBot) {
        commands = ImmutableMap.<String, Command>builder().put(CommandName.START.getCommandName(), new StartCommand(sendMessageToBot))
                                        .put(CommandName.STOP.getCommandName(), new StopCommand(sendMessageToBot))
                                        .put(CommandName.HELP.getCommandName(), new HelpCommand(sendMessageToBot))
                                        .put(CommandName.NO.getCommandName(), new NoCommand(sendMessageToBot))
                                        .build();
        this.unknownCommand = new UnknownCommand(sendMessageToBot);

    }

    public Command retrieveCommand(String commandIdentifier) {
        return commands.getOrDefault(commandIdentifier, unknownCommand);
    }
}
