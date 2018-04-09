/**
 * @Author Cay Horstmann, OOD 3rd edition, code available at http://horstmann.com/oodp2/solutions/solutions.html
 * Modified by Isabelle Delmas: added scroll bars to the text areas
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   Presents a phone GUI for the voice mail system.  When multiple Telephones
   are created, closing the last one will exit the program.
*/
public class Telephone
{
   /**
      Constructs a telephone with a speaker, keypad, and microphone.
   */
   public Telephone()
   {

      numberOfPhones = numberOfPhones + 1;
      JPanel speakerPanel = new JPanel();
      speakerPanel.setLayout(new BorderLayout());
      speakerPanel.add(new JLabel("Speaker:"), BorderLayout.NORTH);
      
      // Create a scroll panel and text area for the speaker
      speakerField = new JTextArea(10, 25);
      JScrollPane scrollSpeaker = new JScrollPane(speakerField);
      scrollSpeaker.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      speakerPanel.add(scrollSpeaker,BorderLayout.CENTER);

      String keyLabels = "123456789*0#";
      JPanel keyPanel = new JPanel();
      keyPanel.setLayout(new GridLayout(4, 3));
      for (int i = 0; i < keyLabels.length(); i++)
      {
         final String label = keyLabels.substring(i, i + 1);
         JButton keyButton = new JButton(label);
         keyPanel.add(keyButton);
         keyButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  connect.dial(label);
               }
            });
      }
      
      // Create a scroll panel and text area for the microphone
      final JTextArea microphoneField = new JTextArea(10, 25);
      JScrollPane scrollMicrophone = new JScrollPane(microphoneField);
      scrollMicrophone.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      
      JButton speechButton = new JButton("Send speech");
      speechButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.record(microphoneField.getText());
               microphoneField.setText("");
            }
         });

      JButton hangupButton = new JButton("Hangup");
      hangupButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.hangup();
            }
         });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(speechButton);
      buttonPanel.add(hangupButton);

      JPanel microphonePanel = new JPanel();
      microphonePanel.setLayout(new BorderLayout());
      microphonePanel.add(new JLabel("Microphone:"), BorderLayout.NORTH);
      microphonePanel.add(scrollMicrophone, BorderLayout.CENTER);
      microphonePanel.add(buttonPanel,BorderLayout.SOUTH);

      final JFrame frame = new JFrame();

      frame.add(speakerPanel,
         BorderLayout.NORTH);
      frame.add(keyPanel,
         BorderLayout.CENTER);
      frame.add(microphonePanel,
         BorderLayout.SOUTH);

      // Replace the default close operation with a window event listener.
      frame.addWindowListener(new
         WindowAdapter()
         {
            public void windowClosing(WindowEvent event)
            {
               if (numberOfPhones == 1)
                  System.exit(0);
               else
               {
                  numberOfPhones = numberOfPhones - 1;
                  frame.dispose();
               }
            }
         });

      frame.pack();
      frame.setVisible(true);
   }

   /**
      Give instructions to the mail system user.
   */
   public void speak(String output)
   {
      speakerField.setText(output);
   }

   public void run(Connection c)
   {
      connect = c;
   }

   private JTextArea speakerField;
   private Connection connect;
   private static int numberOfPhones = 0;
}