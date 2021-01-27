package com.GuilhosInc.Eventos;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter {
	public Message msg;

	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
			event.getMessage().addReaction("✖").queue();
		}
	}

}
