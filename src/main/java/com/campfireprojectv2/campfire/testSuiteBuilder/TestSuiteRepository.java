package com.campfireprojectv2.campfire.testSuiteBuilder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestSuiteRepository extends JpaRepository<TestSuite, Integer>{
	public List<TestSuite> findByName(String name);
}
