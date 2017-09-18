package br.com.indra.jovemprofissional.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.indra.jovemprofissional.model.Usuario;


@Repository
public interface UserRepository extends CrudRepository<Usuario, String> {
	/*
	@Query("SELECT PASSWORD FROM TB_USERLOGIN WHERE USERNAME=name")
	public String GetPass(@Param("name") String name);*/
	
	

	public String QuerySelect="SELECT PASSWORD FROM tb_userlogin WHERE USERNAME=name";
	@Query(value=QuerySelect,nativeQuery=true)
	public String getPass(@Param("name") String name);
	
}

