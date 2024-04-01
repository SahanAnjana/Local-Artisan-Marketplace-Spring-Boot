package lk.ac.vau.fas.artisanMarketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lk.ac.vau.fas.artisanMarketplace.models.Response;
import lk.ac.vau.fas.artisanMarketplace.service.GenericService;
import lk.ac.vau.fas.artisanMarketplace.util.VarList;
@CrossOrigin
public abstract class GenericController<T,ID> {

	@Autowired
	private GenericService<T, ID> service;
	
	@Autowired
    private Response response;
	
	@GetMapping
	public ResponseEntity<Response> getAllEntities(){
		try {
            List<T> list = service.getAll();
            if (list !=null) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(list);
                return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
            } else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("No Data Available");
                response.setContent(null);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(ex.getMessage());
            response.setContent(null);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Response> getEntity(@PathVariable("id") ID id) {
		try {
            T element = service.getEle(id);
            if (element !=null) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(element);
                return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
            } else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("No Data Available For id:"+id);
                response.setContent(null);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(e);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping
	public ResponseEntity<Response> addEntity(@RequestBody T t) {
		try {
            String res=service.addEle(t);
            if (res.equals("00")){
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(t);
                return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);

            }else if(res.equals("06")) {
                response.setCode(VarList.RSP_DUPLICATED);
                response.setMessage("Artist Registered");
                response.setContent(t);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }else {
                response.setCode(VarList.RSP_FAIL);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(ex.getMessage());
            response.setContent(null);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Response> updateEntity(@PathVariable("id") ID id, @RequestBody T t) {
		try {
            String res=service.updateEle(t,id);
            if (res.equals("00")){
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(t);
                return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
            }else if(res.equals("01")) {
                response.setCode(VarList.RSP_DUPLICATED);
                response.setMessage("Not A Registered Artist");
                response.setContent(t);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }else {
                response.setCode(VarList.RSP_FAIL);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(ex.getMessage());
            response.setContent(null);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Response> deleteEntity(@PathVariable("id") ID id) {
		try {
            String res = service.deleteEle(id);
            if (res.equals("00")) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(null);
                return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
            } else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("No Artist Available For this empID");
                response.setContent(null);
                return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(e);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
