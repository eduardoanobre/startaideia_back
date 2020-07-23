package br.com.startaideia.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.startaideia.model.Entidade;

@Table(name = "tag", catalog = "startaideia")
@Entity
public class Tag implements Entidade {

	/**
	 * Construtor default
	 */
	public Tag() {
	}

	/**
	 * Contrutor com descrição
	 * 
	 * @param description
	 * @param tool
	 */
	public Tag(String description, Tool tool) {
		setDescription(description);
		setTool(tool);
	}

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = -3562294810689290892L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String description;

	@ManyToOne
	private Tool tool;

	// getters and setters

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", description=" + description + ", tool=" + tool + "]";
	}

}
