package model.test;

import model.ChatClassification;
import model.Chat;
import model.ChatFileReference;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lucas on 22/05/2017.
 */
public class ChatClassificationTest {
    @Test
    public void testAccuracy() {
        Chat chat = new Chat();
        ChatClassification chatClassification = new ChatClassification(chat, "pedofilo", 94.50);
        assertEquals(94.50, chatClassification.getAccuracy(), 2);
    }

    @Test
    public void testChatClass() {
        Chat chat = new Chat();
        ChatClassification chatClassification = new ChatClassification(chat, "pedofilo", 94.50);
        assertEquals(chat, chatClassification.getChat());
    }

    @Test
    public void testClassification() {
        Chat chat = new Chat();
        ChatClassification chatClassification = new ChatClassification(chat, "pedofilo", 94.50);
        assertEquals("pedofilo", chatClassification.getClassification());
    }
}
