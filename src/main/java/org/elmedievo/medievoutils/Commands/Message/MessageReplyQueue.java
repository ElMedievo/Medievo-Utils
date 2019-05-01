package org.elmedievo.medievoutils.Commands.Message;

import java.util.HashMap;

public class MessageReplyQueue {
    public static HashMap<String, String> messageReplyQueue;

    public static void loadMessageReplyQueue() {
        messageReplyQueue = new HashMap<>();
    }
}
