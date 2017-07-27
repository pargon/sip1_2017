package comparadores;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import dto.*;

public class Ordenar
{

	@SuppressWarnings("unchecked")
	public static void order(List<EntregableGrupoDTO> EntregableGrupoDTOs)
	{

	    Collections.sort(EntregableGrupoDTOs, new Comparator()
	    {
	        public int compare(Object o1, Object o2)
	        {

	            String iter1 = ((EntregableGrupoDTO) o1).getNombreIteracion();
	            String iter2 = ((EntregableGrupoDTO) o2).getNombreIteracion();
	            int iterComp = iter1.compareTo(iter2);

	            if (iterComp != 0)
	            {
	               return iterComp;
	            } else
	            {
	            	String etapa1 = ((EntregableGrupoDTO) o1).getNombreEtapa();
		            String etapa2 = ((EntregableGrupoDTO) o2).getNombreEtapa();
		            int etapaComp = etapa1.compareTo(etapa2);
		            
	            	if (etapaComp != 0)
	            	{
	 	               return etapaComp;
	 	            } else
	 	            {
	 	            	String entreg1 = ((EntregableGrupoDTO) o1).getNombreEntregable();
			            String entreg2 = ((EntregableGrupoDTO) o2).getNombreEntregable();
			            return entreg1.compareTo(entreg2);
	 	            }
	            }
	        }
	    });
	}
}
