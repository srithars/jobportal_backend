package klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import klu.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Query("select count(U) from User U where U.emailid=:emailid")
	public int validateEmail(@Param("emailid") String emailid);
	
	@Query("select count(U) from User U where U.emailid=:username and U.password=:password")
	public int validateCredentials(@Param("username") String username, @Param("password") String password);
}
