package lk.ac.vau.fas.artisanMarketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lk.ac.vau.fas.artisanMarketplace.repo.GenericRepo;
import lk.ac.vau.fas.artisanMarketplace.util.VarList;

public class GenericService<T,ID> {

	@Autowired
	private GenericRepo<T, ID> repo;

	public List<T> getAll(){
		if(repo.findAll().isEmpty()) {
			return null;
		}
		return repo.findAll();
	}
	
	public T getEle(ID id) {
		if (repo.existsById(id)){
            return repo.findById(id).orElse(null);
        }else {
            return null;
        }
	}
	
	public String addEle(T t) {
		try {
			repo.save(t);
            return VarList.RSP_SUCCESS;
		} catch (Exception e) {
			return VarList.RSP_ERROR;
		}
	}
	
	public String updateEle(T t, ID id) {
		if (repo.existsById(id)){
            repo.save(t);
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
	}

		public String deleteEle(ID id) {
			if (repo.existsById(id)){
	            repo.deleteById(id);
	            return VarList.RSP_SUCCESS;
	        }else {
	            return VarList.RSP_NO_DATA_FOUND;
	        }
		}
}
