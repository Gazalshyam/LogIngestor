package com.dyte.service;

import java.util.List;

import com.dyte.model.Log;

public interface LogService {

	public Log ingestLog(Log log);

	public List<Log> getAllLogs();

	public List<Log> getLogsByLevel(String level);

	public List<Log> searchLogsByMessage(String message);

	public List<Log> getLogsByResourceId(String resourceId);

	public List<Log> getLogsByTraceId(String traceId);

	public List<Log> getLogsBySpanId(String spanId);

	public List<Log> getLogsByCommit(String commit);

	public List<Log> getLogsByMetadataParentResourceId(String parentResourceId);

}
