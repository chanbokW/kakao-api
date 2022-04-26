package test;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
@Repository
public class MemberRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Long save(Member member) {
		em.persist(member);
		
		return member.getId();
	}
	@Transactional
	public Member find(Long id) {
		return em.find(Member.class, id);
	}
}
