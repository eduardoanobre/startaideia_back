package br.com.startaideia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.startaideia.model.entidades.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

	@Query("SELECT t.tool FROM Tag t where (t.description =:tag)")
	List<Tool> obterFerramentasFiltradasPorTag(@Param("tag") String tag);

	@Query("SELECT t FROM Tool t where (t.description like :filtro or t.title like :filtro)")
	List<Tool> obterFerramentas(@Param("filtro") String filtro);

	@Query("SELECT DISTINCT(t.description) FROM Tag t")
	String[] obtemTagsCadastradas();

}