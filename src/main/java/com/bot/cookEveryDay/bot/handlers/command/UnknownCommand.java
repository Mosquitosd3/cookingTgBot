package com.bot.cookEveryDay.bot.handlers.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class UnknownCommand implements Command {
    private final String commandName;

    public UnknownCommand() {
        this.commandName = "";
    }
    public UnknownCommand(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public SendMessage execute(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId().toString());
        response.setText("Неизвестная команда. Напиши /help для получения списка доступных команд.");
        return response;
    }
}
