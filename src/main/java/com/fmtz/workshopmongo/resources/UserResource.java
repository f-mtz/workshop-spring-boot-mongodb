package com.fmtz.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fmtz.workshopmongo.domain.User;
import com.fmtz.workshopmongo.dto.UserDTO;
import com.fmtz.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)/**Aqui valeria o @GetMapping p/ dizer q isso fará uma requisição do tipo GET*/
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	/**O Responseentity foi inserido depois, pois ele é uma entidade que permite fazer requisições HTTP porém personalizando
	 * a resposta com os códigos de status dentre outros possíveis recursos desse protocolo
	 * 
	 * Agora ao invés de retornar uma lista puramente, vai haver um retorno com o código de status e com a lista no corpo
	 * da requisição*/
}
