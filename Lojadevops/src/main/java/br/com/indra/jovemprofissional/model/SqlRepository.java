package br.com.indra.jovemprofissional.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.indra.jovemprofissional.repository.UserRepository;

public class SqlRepository implements UserRepository {
	/*@Query
	@Override
	//public String GetUser(@Param("User") Usuario user){}
	
	@Query
	@Override
	public String GetPass(@Param("User") Usuario user){}
	
	@Query
	@Override
	public String GetValue(@Param("User") Usuario user){}*/

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Usuario arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Usuario> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Usuario> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Usuario> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Usuario> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
