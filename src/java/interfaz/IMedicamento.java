/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import modelo.Medicamento;

/**
 *
 * @author Alex
 */
public interface IMedicamento {
    public List<Medicamento> listarMedicamentos();
    public boolean addMedicamento(Medicamento med);
    public boolean deleteMedicamento(int id);
    public List<Medicamento> listarMedicamentoByLaboratorioID(int id);
    public boolean searchMedicamento(String nombreMedicamento);
}
