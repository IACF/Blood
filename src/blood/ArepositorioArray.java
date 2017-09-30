/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IACF
 * @param <Entidade>
 */
public abstract class ArepositorioArray<Entidade> implements Irepositorio<Entidade> {
    ArrayList<Entidade> table = new ArrayList();
    @Override
    public void insert(Entidade e){
        table.add((Entidade) e);
    }
    @Override
    public void clear(){
        table.clear();
    }
    
    @Override
    public List<Entidade> listar(){
        return new ArrayList(table);
    } 
}