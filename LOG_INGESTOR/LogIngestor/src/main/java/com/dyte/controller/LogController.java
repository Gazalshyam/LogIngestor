package com.dyte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dyte.model.Log;
import com.dyte.service.LogService;

@RestController
@RequestMapping("/logs")
public class LogController {

	@Autowired
	private LogService logService;

	@PostMapping("/ingestLog")
	public ResponseEntity<Log> ingestLog(@RequestBody Log log) {

		Log ingestedLog = logService.ingestLog(log);

		return new ResponseEntity<>(ingestedLog, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Log>> getAllLogs() {

		List<Log> allLogs = logService.getAllLogs();

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

	@GetMapping("/level/{level}")
	public ResponseEntity<List<Log>> getLogsByLevel(@PathVariable String level) {

		List<Log> allLogs = logService.getLogsByLevel(level);

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Log>> searchLogsByMessage(@RequestParam String message) {

		List<Log> allLogs = logService.searchLogsByMessage(message);

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

	@GetMapping("/resource/{resourceId}")
	public ResponseEntity<List<Log>> getLogsByResourceId(@PathVariable String resourceId) {

		List<Log> allLogs = logService.getLogsByResourceId(resourceId);

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

	@GetMapping("/traceId/{traceId}")
	public ResponseEntity<List<Log>> getLogsByTraceId(@PathVariable String traceId) {

		List<Log> allLogs = logService.getLogsByTraceId(traceId);

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

	@GetMapping("/spanId/{spanId}")
	public ResponseEntity<List<Log>> getLogsBySpanId(@PathVariable String spanId) {

		List<Log> allLogs = logService.getLogsBySpanId(spanId);

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

	@GetMapping("/commit/{commit}")
	public ResponseEntity<List<Log>> getLogsByCommit(@PathVariable String commit) {

		List<Log> allLogs = logService.getLogsByCommit(commit);

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

	@GetMapping("/metadata/parentResourceId/{parentResourceId}")
	public ResponseEntity<List<Log>> getLogsByMetadataParentResourceId(@PathVariable String parentResourceId) {

		List<Log> allLogs = logService.getLogsByMetadataParentResourceId(parentResourceId);

		return new ResponseEntity<List<Log>>(allLogs, HttpStatus.OK);
	}

}
