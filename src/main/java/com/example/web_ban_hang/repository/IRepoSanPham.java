package com.example.web_ban_hang.repository;


import com.example.web_ban_hang.model.SanPham;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IRepoSanPham extends PagingAndSortingRepository<SanPham,Long> {

}
