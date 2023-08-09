package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import models.Id;
import models.Message;
import views.IdTextView;
import views.MessageTextView;
import youareell.Command;

public class MessageController {

    private TransactionController tctrl;

    public MessageController(TransactionController tt) {
        this.tctrl = tt;
    }

    public void doCommand(Command cmd) {
        if (cmd.getCmd() == Command.Verb.GETMESG) {
            List<Message> msgs = tctrl.getMessages();
            for (int i = 0; i < 10; i++) {
                System.out.println(new MessageTextView(msgs.get(i)).toString());
            }
        }
        if (cmd.getCmd() == Command.Verb.POSTMSG) {
            Message result = tctrl.postMessage(cmd.getArg(1), cmd.getArg(2), cmd.getRest(3));
            System.out.println(new MessageTextView(result).toString());

            String name = "manny ";
            //sc.nextLine();

            String ghname = "benji ";
            //sc.nextLine();

            tctrl.postId(name, ghname);
        }

    }
}