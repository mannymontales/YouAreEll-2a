package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import models.Id;
import views.IdTextView;
import youareell.Command;

public class IdController {
    private HashMap<String, Id> allIds;

    Id tmpId;
    
    private TransactionController tctrl;

    public IdController(TransactionController tt) {
        this.tctrl = tt;
    }

    public void doCommand(Command cmd) {
        if (cmd.getCmd() == Command.Verb.GETIDS) {
            List<Id> ids = tctrl.getIds();
            for (int i = 0; i < 10; i++) {
                System.out.println(new IdTextView(ids.get(i)).toString());
            }
        }

        if (cmd.getCmd() == Command.Verb.POSTID){
            Scanner sc = new Scanner(System.in);

            String name = "manny ";
            //sc.nextLine();

            String ghname = "benji ";
            //sc.nextLine();

            tctrl.postId(name, ghname);
        }
    }
}