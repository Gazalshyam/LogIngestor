package com.dyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dyte.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

	public List<Log> findByLevel(String level);

	public List<Log> findByMessageIgnoreCase(String message);

	public List<Log> findByResourceId(String resourceId);

	public List<Log> findByTraceId(String traceId);

	public List<Log> findBySpanId(String spanId);

	public List<Log> findByCommit(String commit);

	public List<Log> findByMetadataParentResourceId(String parentResourceId);
}
