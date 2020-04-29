package com.Eric;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageActivityType;
//import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        String token = "NjY5MzUzOTc4MzYxODA2OTAx.XinfZQ.7ifzTtAXVPu9ZKt3V01rUvEu5gc";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.addMessageCreateListener(event -> {
            if (event.getMessage().getContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
            if (event.getMessage().getContent().contains("?")){
                event.getChannel().sendMessage("I don't know, but I do know they're coming out with a cherry Sprunk!");
            }
            if (event.getMessage().getContent().contains("distance")){
                String split1[] = event.getMessage().getContent().split(" ");
                String c1[] = split1[1].split(",");
                String c2[] = split1[2].split(",");
                double results = Math.sqrt(Math.pow((Integer.valueOf(c2[0])-Integer.valueOf(c1[0])), 2) + Math.pow((Integer.valueOf(c2[1]) - Integer.valueOf(c1[1])), 2));
                event.getChannel().sendMessage("Distance formula: sqrt((x\u2082-x\u2081)\u00b2 + (y\u2082 - y\u2081)\u00b2");
                event.getChannel().sendMessage("\u221a((" + c2[0] + "-" + c1[0] + ")\u00b2 + (" + c2[1] + "-" + c1[1] + ")\u00b2)");
                event.getChannel().sendMessage(String.valueOf(results));
            }
            if (event.getMessage().getContent().contains("midpoint")){
                String split1[] = event.getMessage().getContent().split(" ");
                String c1[] = split1[1].split(",");
                String c2[] = split1[2].split(",");
                double result1 = ((Integer.valueOf(c1[0]) + Integer.valueOf(c2[0]))/2);
                double result2 = ((Integer.valueOf(c1[1]) + Integer.valueOf(c2[1]))/2);
                event.getChannel().sendMessage("Midpoint formula: (x\u2082 + x\u2081)/2 , (y\u2082 +y\u2081)/2");
                event.getChannel().sendMessage("(" + c2[0] + " + " + c1[0] + ")/2 , " + "(" + c2[1] + " + " + c1[1] + ")/2");
                event.getChannel().sendMessage(String.valueOf(result1) + ", " + String.valueOf(result2));
            }
            //This section of code below Prints for every "?" in the message
            /*for (int i = 0; i < event.getMessage().getContent().length(); i ++){
                if (event.getMessage().getContent().charAt(i) == '?'){
                    event.getChannel().sendMessage("I don't know, but I do know they're coming out with a cherry Sprunk!");
                    TimeUnit.SECONDS.sleep(1);
                }
            }*/
        });
    }
}
