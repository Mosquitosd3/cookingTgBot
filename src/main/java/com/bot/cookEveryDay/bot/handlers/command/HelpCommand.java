package com.bot.cookEveryDay.bot.handlers.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class HelpCommand implements Command {
    @Override
    public SendMessage execute(Message message) {
        String name = message.getFrom().getFirstName();
        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId().toString());
        response.setText(
                name
                +  ", список доступных команд: \"/Start\", \"/Help\", \"/Dish\"");
        return response;
    }
}
