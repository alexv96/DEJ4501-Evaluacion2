/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import modelo.Laboratorio;

/**
 *
 * @author Alex
 */
public interface ILaboratorio {
    public List<Laboratorio> getLaboratorios();
    public Laboratorio getLaboratorioByID(int id);
}
