package br.com.startaideia.model.dto;

import java.io.Serializable;

/**
 * 
 * nova ferramenta
 *
 */
public class NewToolDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = -945660884494368458L;

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

}
