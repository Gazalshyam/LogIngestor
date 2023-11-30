package com.dyte.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyte.model.Log;
import com.dyte.repository.LogRepository;

@Service
public class LogServiceImplementation implements LogService {

	@Autowired
	private LogRepository logRepository;

	@Override
	public Log ingestLog(Log log) {

		return logRepository.save(log);

	}

	@Override
	public List<Log> getAllLogs() {
		return logRepository.findAll();
	}

	@Override
	public List<Log> getLogsByLevel(String level) {
		return logRepository.findByLevel(level);
	}

	@Override
	public List<Log> searchLogsByMessage(String message) {
		return logRepository.findByMessageIgnoreCase(message);
	}

	@Override
	public List<Log> getLogsByResourceId(String resourceId) {
		return logRepository.findByResourceId(resourceId);
	}

	@Override
	public List<Log> getLogsByTraceId(String traceId) {
		return logRepository.findByTraceId(traceId);
	}

	@Override
	public List<Log> getLogsBySpanId(String spanId) {
		return logRepository.findBySpanId(spanId);
	}

	@Override
	public List<Log> getLogsByCommit(String commit) {
		return logRepository.findByCommit(commit);
	}

	@Override
	public List<Log> getLogsByMetadataParentResourceId(String parentResourceId) {
		return logRepository.findByMetadataParentResourceId(parentResourceId);
	}

}
