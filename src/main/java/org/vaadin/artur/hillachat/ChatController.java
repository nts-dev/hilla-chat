package org.vaadin.artur.hillachat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks.EmitResult;

@RestController
@RequestMapping("/api")
public class ChatController extends ChatEndpoint {

    @PostMapping(path = "/send")
    public void send(@RequestBody MessageForm messageForm) {
        System.out.println("sending........." + messageForm.getMessage());

        try {
            super.chatSink.emitNext(messageForm.getMessage(), (signalType, emitResult) -> (emitResult == EmitResult.FAIL_NON_SERIALIZED));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
