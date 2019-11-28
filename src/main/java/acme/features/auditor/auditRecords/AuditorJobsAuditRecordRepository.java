
package acme.features.auditor.auditRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobsAuditRecordRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select a from AuditRecord a where a.auditor.id = ?1")
	Collection<AuditRecord> findManyByAuditorId(int auditorId);

	@Query("select j from Job j where j.id = ?1")
	Job findJobByAuditRecordId(int auditRecordId);

	@Query("select j from Job j where j.id != ?1")
	Job findJobWithoutAuditRecordId(int auditRecordId);

}
