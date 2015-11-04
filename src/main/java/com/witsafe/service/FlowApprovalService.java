package com.witsafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witsafe.dao.FlowApprovalMapper;

@Service
public class FlowApprovalService {
	@Autowired
	private FlowApprovalMapper flowApprovalMapper;

}
