package com.magneticmojo.rpsapi.api.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.magneticmojo.rpsapi.api.state.PlayerOneJoinedState;

import java.io.IOException;

/**
 * Serializer class for converting the PlayerOneJoinedState object to JSON format.
 * This class extends the StdSerializer class and is specifically designed to handle the serialization
 * of the PlayerOneJoinedState class.
 */
public class PlayerOneJoinedStateSerializer extends StdSerializer<PlayerOneJoinedState> {

    public PlayerOneJoinedStateSerializer() {
        super(PlayerOneJoinedState.class);
    }

    @Override
    public void serialize(
            PlayerOneJoinedState state,
            JsonGenerator gen,
            SerializerProvider provider)
            throws IOException {

        gen.writeStartObject();
        gen.writeStringField("message", state.playerOne().name() + " created new game");
        gen.writeStringField("playerOne", state.playerOne().name());
        gen.writeEndObject();
    }
}
