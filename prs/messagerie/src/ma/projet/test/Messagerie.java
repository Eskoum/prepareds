/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Emp;
import ma.projet.beans.Message;
import ma.projet.sevice.EmpService;
import ma.projet.sevice.MessageService;

/**
 *
 * @author LENOVO
 */
public class Messagerie {
    public static void main(String[] args) {
        // Créez trois employés
        EmpService employeService = new EmpService();
        //Teste Employe
   EmpService es = new EmpService();

es.create(new Emp("LACHGAR", "Mohamed"));
es.create(new Emp("RAMI", "ALI"));
es.create(new Emp("SAFI", "Fatima"));
for(Emp emp : es.getAll())
System.out.println(""+emp.getNom());

List<Message> messagesRecusParEmploye3 = MessageService.getMessagesRecus(es.create(new Emp("SAFI", "Fatima")));
        for (Message message : messagesRecusParEmploye3) {
            System.out.println("Message reçu par employé 3 : " + message.getObject());
        }

       
    
}
    
    }

