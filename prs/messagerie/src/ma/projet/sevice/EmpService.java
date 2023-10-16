/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.sevice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Emp;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author LENOVO
 */
public class EmpService implements IDao<Emp> {
@Override
public boolean create(Emp o) {
try {
String req = "insert into emp (nom, prenom) values(?,?)";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getNom());
ps.setString(2, o.getPrenom());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(EmpService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean update(Emp o) {
try {
String req = "update emp set nom = ? , prenom = ? where id =?";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getNom());
ps.setString(2, o.getPrenom());
ps.setInt(3, o.getId());
if (ps.executeUpdate() == 1) {
return true; 
}
} catch (SQLException ex) {
Logger.getLogger(EmpService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean delete(Emp o) {
try {
String req = "delete from emp where id = ?";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ps.setInt(1, o.getId());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(EmpService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}

public Emp getById(int id) {
Emp emp = null;
try {
String req = "select * from emp where id = ?";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
if(rs.next())
emp = new Emp(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"));
} catch (SQLException ex) {
Logger.getLogger(EmpService.class.getName()).log(Level.SEVERE,
null, ex);
}
return emp;
}

public List<Emp> getAll() {
List <Emp> emps = new ArrayList<>();
try {
String req = "select * from emp ";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ResultSet rs = ps.executeQuery();
while(rs.next())
emps.add(new Emp(rs.getInt("id"),
rs.getString("nom"), rs.getString("prenom")));
} catch (SQLException ex) {
    Logger.getLogger(EmpService.class.getName()).log(Level.SEVERE,
null, ex);
}
return emps;
}

    @Override
    public Emp findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emp> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
    

