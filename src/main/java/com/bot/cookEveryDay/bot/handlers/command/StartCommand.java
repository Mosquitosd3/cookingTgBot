package com.bot.cookEveryDay.bot.handlers.command;

import com.bot.cookEveryDay.service.UserService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class StartCommand implements Command {
    private final UserService service;

    public StartCommand(UserService service) {
        this.service = service;
    }

    @Override
    public SendMessage execute(Message message) {
        String firstName = message.getFrom().getFirstName();
        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId().toString());
        response.setText("Привет! "
                + firstName
                +  ", я бот который поможет тебе готовить");
        service.save(
                message.getFrom().getId(),
                message.getFrom().getFirstName(),
                message.getFrom().getLastName(),
                message.getFrom().getUserName()
                );
        return response;
    }
}
