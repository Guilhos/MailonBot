package com.GuilhosInc.Mailon;

import javax.security.auth.login.LoginException;

import com.GuilhosInc.Comandos.*;
import com.GuilhosInc.Eventos.Reactions;
import com.GuilhosInc.Eventos.Delete;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
	
	public static String prefix = "*";

	public static void main(String[] args) throws LoginException, InterruptedException {
		JDA jda = JDABuilder
				.createLight("KEY",
						GatewayIntent.GUILD_MESSAGES,GatewayIntent.GUILD_MESSAGE_REACTIONS)
				.setActivity(Activity.playing("Use o prefixo " + prefix)).build();
		
		jda.addEventListener(new Commands());
		jda.addEventListener(new Clear());
		jda.addEventListener(new Reactions());
		jda.addEventListener(new Delete());

		jda.awaitReady();
	}

}
