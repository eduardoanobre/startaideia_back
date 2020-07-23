package br.com.startaideia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.startaideia.model.dto.NewToolDto;
import br.com.startaideia.model.dto.ToolDto;
import br.com.startaideia.model.entidades.Tag;
import br.com.startaideia.model.entidades.Tool;
import br.com.startaideia.repositories.ToolRepository;
import br.com.startaideia.utils.StringUtils;

@Service
public class ApiService {

	@Autowired
	private ToolRepository toolRepository;

	/**
	 * obtém todas as tags cadastradas
	 * 
	 * @return - String[]
	 */
	public String[] obtemTagsCadastradas() {
		return toolRepository.obtemTagsCadastradas();
	}

	/**
	 * obtem todas as ferramentas cadastradas com filtro
	 * 
	 * @param filtro
	 * @return - ToolDto[]
	 */
	public ToolDto[] obterFerramentasCadastradas(String filtro) {
		List<Tool> tools = toolRepository.obterFerramentas(StringUtils.filtroLike(filtro));
		return ToolDto.parse(tools);
	}

	/**
	 * obtém ferramentas filtradas por tag
	 * 
	 * @param tag
	 * @return -ToolDto[]
	 */
	public ToolDto[] obterFerramentasFiltradasPorTag(String tag) {
		List<Tool> tools = toolRepository.obterFerramentasFiltradasPorTag(tag);
		return ToolDto.parse(tools);
	}

	/**
	 * cadastra nova ferramenta
	 * 
	 * @param novaFerramenta
	 * @return - ResponseEntity<ToolDto>
	 */
	public ResponseEntity<ToolDto> cadastrarNovaFerramenta(NewToolDto novaFerramenta) {
		Tool tool = new Tool();
		tool.setTitle(novaFerramenta.getTitle());
		tool.setLink(novaFerramenta.getLink());
		tool.setDescription(novaFerramenta.getDescription());
		tool.setTags(parseTags(novaFerramenta.getTags(), tool));
		toolRepository.save(tool);
		return new ResponseEntity<>(ToolDto.parse(tool), HttpStatus.CREATED);
	}

	/**
	 * remove ferramenta por id
	 * 
	 * @param id
	 * @return - ResponseEntity<String>
	 */
	public ResponseEntity<String> removerFerramentaPorId(long id) {

		Tool tool = toolRepository.findById(id).orElse(null);

		if (tool == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		toolRepository.delete(tool);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * faz o parse de List<Tag> para String[]
	 * 
	 * @param tags
	 * @return
	 */
	private List<Tag> parseTags(String[] tags, Tool tool) {

		List<Tag> listaTags = new ArrayList<Tag>();

		if (tags == null || tags.length == 0) {
			return listaTags;
		}

		for (int i = 0; i < tags.length; i++) {
			listaTags.add(new Tag(tags[i], tool));
		}
		return listaTags;
	}

}
