package edu.eci.arsw.clickrace;

import org.springframework.beans.factory.annotation.*;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.*;

import edu.eci.arsw.clickrace.services.ClickRaceServices;


@Controller
public class STOMPMessagesHandler {

	@Autowired
	SimpMessagingTemplate msgt;
    @Autowired
    ClickRaceServices services;
    private Boolean flag =true;
    private Boolean ganador = false;

	@MessageMapping("/carrera{num}")
	public synchronized void loadEvent(String ts,@DestinationVariable String num) throws Exception {
        if(services.getRegisteredPlayers(25).size()==5&&flag){
            flag = false;
            msgt.convertAndSend("/topic/carrera"+num, ts);
        }
	}
    @MessageMapping("/car{num}")
	public synchronized void winnerEvent(String ts,@DestinationVariable String num) throws Exception {
        if(!ganador){
            if(Integer.parseInt(ts.split(":")[2].replace("}",""))>=640){
                services.setWinner(25,Integer.parseInt(num));
                ganador=true;
                msgt.convertAndSend("/topic/carrera25","Tenemos Ganador");
            };
            msgt.convertAndSend("/topic/car"+num, ts);
        }
	}

}