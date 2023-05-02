package com.bot.cookEveryDay.bot.handlers;

import com.bot.cookEveryDay.bot.handlers.command.Command;
import com.bot.cookEveryDay.bot.handlers.command.HelpCommand;
import com.bot.cookEveryDay.bot.handlers.command.StartCommand;
import com.bot.cookEveryDay.bot.handlers.command.UnknownCommand;
import com.bot.cookEveryDay.service.UserService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandHandler {
    private final Map<String, Command> commandMap = new HashMap<>();
    private final UserService service;

    public CommandHandler(UserService service) {
        this.service = service;
        initCommand();
    }

    public SendMessage handle(Message message) {
        String commandName = message.getText().split(" ")[0];
        Command command = commandMap.getOrDefault(commandName, new UnknownCommand());
        return command.execute(message);
    }

    private void initCommand() {
        commandMap.put("/start", new StartCommand(service));
        commandMap.put("/help", new HelpCommand());
    }
}
