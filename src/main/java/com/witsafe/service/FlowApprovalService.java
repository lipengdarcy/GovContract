package com.witsafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witsafe.contracts.dao.FlowApprovalMapper;

@Service
public class FlowApprovalService {
	@Autowired
	private FlowApprovalMapper flowApprovalMapper;

}
