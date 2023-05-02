package com.bot.cookEveryDay.bot.handlers.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Command {
    SendMessage execute(Message message);
}
