package ma.projet.sevice;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import ma.projet.beans.Emp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Message;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

public class MessageService implements IDao<Message> {

    public static List<Message> getMessagesRecus(boolean create) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private EmpService es;
public MessageService() {
es = new EmpService();
}
@Override
public boolean create(Message o) {
try {
String req = "insert into message (objet, sujet, date, idE, idR)values(?,?,?,?,?)";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getObject());
ps.setString(2, o.getSujet());
ps.setDate(3, (java.sql.Date) new Date(o.getDate().getTime()));
ps.setInt(4, o.getEmpEmetteur().getId());
ps.setInt(5, o.getEmpRecepteur().getId());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean update(Message o) {
return false;
}
@Override
public boolean delete(Message o) {
return false;
}

public Message getById(int id) {
Message emp = null;
try {
    String req = "select * from message ";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ResultSet rs = ps.executeQuery();
while(rs.next())
messages.add(new Message(rs.getString("objet"),
rs.getString("sujet"), rs.getDate("date")));

}
catch (SQLException ex) {
Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
null, ex);
}
return emp;
}

public List<Message> getAll() {
List<Message> employes = new ArrayList<>();
try {
String req = "select * from message ";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
 Message message = new Message();
    message.setObjet(rs.getString("objet"));
    message.setSujet(rs.getString(""));
    message.setDate(rs.getDate("date_envoi"));
}
} catch (SQLException ex) {
Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
null, ex);
}
return employes;
}

    
    public Message findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Message> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
