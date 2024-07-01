package com.example.unesso.services;

import com.example.unesso.model.CatDistrito;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatMunicipio;
import com.example.unesso.model.CatRegion;

import java.util.List;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatMunicipio en el sistema.
 */
public interface ICatMunicipioService {
	List<CatMunicipio> listaMunicipiosPorEstado(CatEstado estado);
	CatMunicipio municipioPorId(Integer id);
	List<CatMunicipio> municipiosPorIdCatEstado(Integer idCatEstado);
	CatEstado estadoPorIdCatMunicipio(Integer idCatMunicipio);
	CatRegion regionPorIdMinucipio (Integer idCatRegion);

	CatDistrito distritoPorIdMunicipio (Integer idMunicipio);

}
