package br.com.startaideia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.startaideia.model.dto.NewToolDto;
import br.com.startaideia.model.dto.ToolDto;
import br.com.startaideia.services.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value = "API Desafio Startaideia")
@RestController
@RequestMapping(value = "/api/v1/startaideia")
public class ApiController {

	@Autowired
	private ApiService service;

	@ApiOperation(value = "retorna todas as tags cadastradas", response = String[].class)
	@GetMapping("/tags")
	public String[] obtemTagsCadastradas() {
		return service.obtemTagsCadastradas();
	}

	@ApiOperation(value = "retorna todas as ferramentas cadastradas", response = ToolDto[].class)
	@GetMapping(value = { "/tools/", "/tools/{filtro}" })
	public ToolDto[] obtemFerramentasCadastradas(@PathVariable(required = false) String filtro) {
		return service.obterFerramentasCadastradas(filtro);
	}

	@ApiOperation(value = "retorna as ferramentas filtradas por tag", response = ToolDto[].class)
	@GetMapping("/tools")
	public ToolDto[] obterFerramentasFiltradasPorTag(@RequestParam(name = "tag") String tag) {
		return service.obterFerramentasFiltradasPorTag(tag);
	}

	@ApiOperation(value = "cadastra nova ferramenta", response = ResponseEntity.class)
	@PostMapping(path = "/tools")
	@ResponseBody
	public ResponseEntity<ToolDto> cadastrarNovaFerramenta(@RequestBody NewToolDto novaFerramenta) {
		return service.cadastrarNovaFerramenta(novaFerramenta);
	}

	@ApiOperation(value = "remover ferramenta por ID", response = ResponseEntity.class)
	@DeleteMapping(path = "/tools/{id}")
	public ResponseEntity<String> removerFerramentaPorId(@PathVariable("id") long id) {
		return service.removerFerramentaPorId(id);
	}

}
