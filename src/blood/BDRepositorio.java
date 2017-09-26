/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

/**
 *
 * @author IACF
 */
public class BDRepositorio<Entidade> implements Irepositorio<Entidade> {

    private String table;
    
    public BDRepositorio(String table) {
        this.table = table;
    }

    
    
    @Override
    public void insert(Entidade e) {
        System.out.println("inseriu");
        //String cmd = "insert into "+table+" values()";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
