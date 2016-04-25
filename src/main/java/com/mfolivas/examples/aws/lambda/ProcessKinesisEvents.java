package com.mfolivas.examples.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

import java.io.IOException;

/**
 * @author Marcelo Olivas
 */
public class ProcessKinesisEvents {
    public static void recordHandler(KinesisEvent event) throws IOException {
        
        event.getRecords()
        .stream()
        .forEach(rec -> {
            System.out.format("Event [%s-%s](vesion %s) from :%s: stored-data >%s<\n"
                    , rec.getEventID()
                    , rec.getEventName()
                    , rec.getEventVersion()
                    , rec.getEventSource()
                    , new String(rec.getKinesis().getData().array())
                    );
            });
    }
}

