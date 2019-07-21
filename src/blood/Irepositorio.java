/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

import java.util.List;

/**
 *
 * @author IACF
 * @param <Entidade>
 */
public interface Irepositorio<Entidade> {
    public void insert(Entidade e);
    public void clear();
    public List<Entidade> listar();
}
