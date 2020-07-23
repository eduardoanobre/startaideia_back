package br.com.startaideia.model.dto;

import java.io.Serializable;
import java.util.List;

import br.com.startaideia.model.entidades.Tag;
import br.com.startaideia.model.entidades.Tool;

/**
 * 
 * DTO de Tool
 *
 */
public class ToolDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = -7361574264483937412L;

	/**
	 * id de tool
	 */
	private long id;

	/**
	 * title de tool
	 */
	private String title;

	/**
	 * descrição de tool
	 */
	private String description;

	/**
	 * link de tool
	 */
	private String link;

	/**
	 * Lista de tags
	 */
	private String[] tags;

	// getters and setters

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getLink() {
		return link;
	}

	public String[] getTags() {
		return tags;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * Faz o parse de Tool para ToolDto
	 * 
	 * @param tool
	 * @return - ToolDto
	 */
	public static ToolDto parse(Tool tool) {

		String[] tags = new String[tool.getTags().size()];

		int i = 0;
		for (Tag tag : tool.getTags()) {
			tags[i] = tag.getDescription();
			i++;
		}

		ToolDto poolDto = new ToolDto();
		poolDto.setId(tool.getId());
		poolDto.setTitle(tool.getTitle());
		poolDto.setLink(tool.getLink());
		poolDto.setDescription(tool.getDescription());
		poolDto.setTags(tags);
		return poolDto;
	}

	/**
	 * Faz o parse de List<Tool> para ToolDto[]
	 * 
	 * @param tools
	 * @return
	 */
	public static ToolDto[] parse(List<Tool> tools) {
		ToolDto[] toolsDto = new ToolDto[tools.size()];

		int i = 0;
		for (Tool tool : tools) {
			toolsDto[i] = ToolDto.parse(tool);
			i++;
		}
		;
		return toolsDto;
	}

}
