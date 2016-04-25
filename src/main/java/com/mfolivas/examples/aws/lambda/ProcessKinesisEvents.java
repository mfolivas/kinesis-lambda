package com.mfolivas.examples.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

import java.io.IOException;

/**
 * @author Marcelo Olivas
 */
public class ProcessKinesisEvents {
    public static void recordHandler(KinesisEvent event) throws IOException {
        event.getRecords().stream().forEach(rec -> System.out.println(new String(rec.getKinesis().getData().array())));
    }
}

