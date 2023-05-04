package core.persistence.repository;

import org.springframework.stereotype.Repository;

import core.persistence.entities.UrpUser;
import core.persistence.projections.IUrpWeakUser;

import org.springframework.data.jpa.repository.*;


@Repository
public interface UrpUsersCrudRepository extends JpaRepository<UrpUser,Long>{

	
	UrpUser findByUserName(String username);
	
	UrpUser deleteByUserName(String username);
	
	@Query(value = "SELECT P.user_name as userName , A.issued_date as issuedDate, A.weak  FROM urp_users P INNER JOIN urp_passwords A ON A.password_oid=P.oid", nativeQuery = true)
	public IUrpWeakUser findWeakUser();
	
	
	
}
