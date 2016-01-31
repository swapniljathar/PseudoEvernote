package View;

import Control.saveNote;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Swapnil on 1/21/2016.
 */
public class NewNoteView {
    private JButton cancelButton;
    private JButton saveButton;
    private JButton resetButton;
    private JTextArea textArea1;
    private JPanel NewNote;
    private static int userId;
    private static MainView mFrame;


    public NewNoteView(final JFrame frame) {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNote.save(textArea1.getText(), userId);
                frame.dispose();
                mFrame.show();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }


    public static void newNote(int id, MainView mFrame) {
        JFrame frame = new JFrame("NewNoteView");
        frame.setContentPane(new NewNoteView(frame).NewNote);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        setmFrame(mFrame);
        setUserId(id);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setUserId(int id) {
        userId = id;
    }

    public static void setmFrame(MainView mainFrame){
        mFrame = mainFrame;
    }

}

