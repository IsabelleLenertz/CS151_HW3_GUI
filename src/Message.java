/**
 * @Author Cay Horstmann, OOD 3rd edition, code available at http://horstmann.com/oodp2/solutions/solutions.html
 * 
 */


/**
   A message left by the caller.
*/
public class Message
{
   /**
      Construct a Message object.
      @param messageText the message text
   */
   public Message(String messageText)
   {
      text = messageText;
   }

   /**
      Get the message text.
      @return message text
   */
   public String getText()
   {
      return text;
   }

   private String text;
}