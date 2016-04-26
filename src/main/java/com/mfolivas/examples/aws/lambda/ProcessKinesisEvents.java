package com.mfolivas.examples.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Marcelo Olivas
 */
public class ProcessKinesisEvents {
    public static void recordHandler(KinesisEvent event) throws IOException {
        Optional.ofNullable( event.getRecords())
        .map(records -> records.stream())
        .ifPresent(stream -> {
            stream.forEach(rec -> {
                System.out.format("Event [%s]-[%s](vesion %s) from :%s: stored-data >%s<\n"
                        , rec.getEventID()
                        , rec.getEventName()
                        , rec.getEventVersion()
                        , rec.getEventSource()
                        , rec.getInvokeIdentityArn()
                        , new String(rec.getKinesis().getData().array())
                        );
                
                });
        });
    }
}

