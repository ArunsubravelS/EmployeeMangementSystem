package com.project.ems.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PaginationService {

    public <Employee> Page<Employee> getPage(List<Employee> list, int page) {
        int pageSize = 20;
        int totalItems = list.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        // Calculate the starting and ending indexes for the current page
        int startIndex = page * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalItems);

        return new PageImpl<>(list.subList(startIndex, endIndex), PageRequest.of(page, pageSize), totalItems);
    }
}