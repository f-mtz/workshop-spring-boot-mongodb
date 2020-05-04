package com.fmtz.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fmtz.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET) /**Aqui valeria o @GetMapping p/ dizer q isso fará uma requisição do tipo GET*/
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Silva", "Maria@gmail");
		User john = new User("2", "John", "john@gmail");
		User julius = new User("3", "Julius", "julius@gmail");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, john));
		
		return ResponseEntity.ok().body(list);
	}
	
	/**O Responseentity foi inserido depois, pois ele é uma entidade que permite fazer requisições HTTP porém personalizando
	 * a resposta com os códigos de status dentre outros possíveis recursos desse protocolo
	 * 
	 * Agora ao invés de retornar uma lista puramente, vai haver um retorno com o código de status e com a lista no corpo
	 * da requisição*/
}
