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

	            int iter1 = ((EntregableGrupoDTO) o1).getNroOrdenIteracion();
	            int iter2 = ((EntregableGrupoDTO) o2).getNroOrdenIteracion();
	            int iterComp = iter1 - iter2;

	            if (iterComp != 0)
	            {
	               return iterComp;
	            } else
	            {
	            	int etapa1 = ((EntregableGrupoDTO) o1).getNroOrdenEtapa();
		            int etapa2 = ((EntregableGrupoDTO) o2).getNroOrdenEtapa();
		            int etapaComp = etapa1 - etapa2;
		            
	            	if (etapaComp != 0)
	            	{
	 	               return etapaComp;
	 	            } else
	 	            {
	 	            	int entreg1 = ((EntregableGrupoDTO) o1).getNroOrdenEntregable();
	 	            	int entreg2 = ((EntregableGrupoDTO) o2).getNroOrdenEntregable();
			            return entreg1 - entreg2;
	 	            }
	            }
	        }
	    });
	}
}
