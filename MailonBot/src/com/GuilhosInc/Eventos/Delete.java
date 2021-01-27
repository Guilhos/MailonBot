package com.GuilhosInc.Eventos;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Delete extends ListenerAdapter {
	Reactions reac = new Reactions();
	
	public void onMessageReactionAdd(MessageReactionAddEvent event) {
		if(event.getReactionEmote().getName().equals("✖") && !event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
			event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();
		}
	}
}
