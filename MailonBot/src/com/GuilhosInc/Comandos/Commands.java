package com.GuilhosInc.Comandos;

import com.GuilhosInc.Mailon.Main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		MessageChannel channel = event.getChannel();
		long time = System.currentTimeMillis();
		if (args[0].equals(Main.prefix + "help")) {
			channel.sendTyping().queue();
			channel.sendMessage("Vai se fuder " + event.getAuthor().getAsMention() + " eu só falo português!").queue();
		} else if (args[0].equals(Main.prefix + "ping")) {
			channel.sendTyping().queue();
			channel.sendMessage(event.getAuthor().getAsMention() + " Pong!").queue(response -> {
				response.editMessageFormat("Pong!", System.currentTimeMillis() - time).queue();
			});
		} else if (args[0].equals(Main.prefix + "pong")) {
			channel.sendTyping().queue();
			channel.sendMessage(event.getAuthor().getAsMention() + " Ping!").queue(response -> {
				response.editMessageFormat("Ping!", System.currentTimeMillis() - time).queue();
			});
		} else if (args[0].equals(Main.prefix + "comandos")) {
			EmbedBuilder comandos = new EmbedBuilder();
			comandos.setTitle("🐕 COMANDOS 🐕‍");
			comandos.setDescription("Aqui você aprende a usar o grandioso MAILON");
			comandos.addField("Comandos: ",
					Main.prefix + "comandos | " + Main.prefix + "help | " + Main.prefix + "ping | " + Main.prefix
							+ "felizanivNASA | " + Main.prefix + "limpar (número) | " + Main.prefix + "vaisefoder | " + Main.prefix + "cabelo",
					false);
			comandos.setColor(0x993399);
			comandos.setFooter("Criado por Guilhos",
					"https://cdn.discordapp.com/attachments/707954953280421928/800491326687674419/Foto_Lendaria.png");

			channel.sendTyping().queue();
			channel.sendMessage(comandos.build()).queue();

			comandos.clear();
		} else if (args[0].equals(Main.prefix + "felizanivNASA")) {
			channel.sendTyping().queue();
			channel.sendMessage("FELIZ ANIVERSÁRIO NASA!!!!!!").queue();
			channel.sendMessage(
					" https://cdn.discordapp.com/attachments/707954953280421928/800451814515802142/joao_anao.jpg")
					.queue();
		} else if (args[0].equals(Main.prefix + "vaisefoder")) {
			channel.sendTyping().queue();
			channel.sendMessage("Vai tu otário, seu pau no cu!").queue();
		} else if (args[0].equals(Main.prefix + "cabelo")) {
			channel.sendTyping().queue();
			channel.sendMessage(
					"https://images-ext-1.discordapp.net/external/z0eWv9g72Qh2jXJREwwsshSWJYXNa04F-nETKgGUdQ8/https/loritta.website/assets/img/actions/slap/female_x_female/gif_205.gif")
					.queue();
		}

	}
}
