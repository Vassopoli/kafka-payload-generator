package com.alivassopoli;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/avro")
public class AvroResource {
    private static final Logger LOGGER = Logger.getLogger(AvroResource.class);

    @Channel("my-topic-name")
    Emitter<Object> emitter;

    @POST
    public Response generatePayload(Object object) {
        LOGGER.infof("Sending avro message %s to Kafka broker", object);
        emitter.send(object);
        return Response.accepted().build();
    }
}
