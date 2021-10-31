package command;

import com.github.DmitryDK3.wordmemotgbot.service.SendMessageToBot;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import static command.CommandName.HELP;
import static command.CommandName.NO;
import static command.CommandName.START;
import static command.CommandName.STOP;

@Component
public class CommandContainer {

    private final ImmutableMap<String,Command> commands;

    private Command unknownCommand;

    public CommandContainer(SendMessageToBot sendMessageToBot) {
        commands = ImmutableMap.<String, Command>builder().put(START.getCommandName(), new StartCommand(sendMessageToBot))
                                        .put(STOP.getCommandName(), new StopCommand(sendMessageToBot))
                                        .put(HELP.getCommandName(), new HelpCommand(sendMessageToBot))
                                        .put(NO.getCommandName(), new NoCommand(sendMessageToBot))
                                        .build();
        this.unknownCommand = new UnknownCommand(sendMessageToBot);

    }

    public Command retrieveCommand(String commandIdentifier) {
        return commands.getOrDefault(commandIdentifier, unknownCommand);
    }
}
