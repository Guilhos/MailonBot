package com.GuilhosInc.Comandos;

import java.util.List;

import com.GuilhosInc.Mailon.Main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		if (event.getMember().getRoles().size() >= 5) {
			if (args[0].equalsIgnoreCase(Main.prefix + "limpar")) {
				if (args.length < 2) {
					EmbedBuilder error = new EmbedBuilder();
					error.setColor(0xFF0000);
					error.setTitle("🔺 ERRO 🔻");
					error.setDescription("Tu não disse quantas messagens eu apago, burro!");

					event.getChannel().sendMessage(error.build()).queue();
				} else {
					try {
						List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]))
								.complete();
						event.getTextChannel().deleteMessages(messages).queue();
						EmbedBuilder sucess = new EmbedBuilder();
						sucess.setColor(0xFF0000);
						sucess.setTitle("🔰 SUCESSO 🔰");
						sucess.setDescription(Integer.parseInt(args[1]) + " mensagens foram jogadas no lixo!");

						event.getChannel().sendMessage(sucess.build()).queue();
					} catch (IllegalArgumentException e) {
						if (Integer.parseInt(args[1]) > 100) {
							EmbedBuilder error = new EmbedBuilder();
							error.setColor(0xFF0000);
							error.setTitle("🔺 ERRO 🔻");
							error.setDescription("Tu só pode apagar até 100 parcero!");

							event.getChannel().sendMessage(error.build()).queue();
						} else {
							EmbedBuilder error = new EmbedBuilder();
							error.setColor(0xFF0000);
							error.setTitle("🔺 ERRO 🔻");
							error.setDescription("Mensagens muito velhas! Não gosto de velho");

							event.getChannel().sendMessage(error.build()).queue();
						}
					}
				}
			}
		}
	}
}
